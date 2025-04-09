import { Tarefa } from './../../../model/Tarefa';
import { Component, OnInit} from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { FormBuilder, ReactiveFormsModule, FormsModule, FormGroup, Validators } from '@angular/forms';
import { TarefasService } from '../../../services/Requisicoes/tarefas.service';
import { infoProjeto } from '../../../model/infoProjeto';
import { CommonModule } from '@angular/common';
import { TarefaClassificacaoService } from './model/TarefaClassificacoes.service';
import { DropdownService } from '../../../services/dropdown.service';
import { DropdownClassificacaoComponent } from "../../dropdown/dropdown-classificacao/dropdown-classificacao.component";
import { DropdownEtapaComponent } from "../../dropdown/dropdown-etapa/dropdown-etapa.component";
import { TarefaEtapaService } from './model/TarefaEtapa.service';
import { DropdownPrioridadeComponent } from "../../dropdown/dropdown-prioridade/dropdown-prioridade.component";
import { DropdownStatusComponent } from "../../dropdown/dropdown-status/dropdown-status.component";
import { TarefaStatusService } from './model/TarefaStatus.service';
import { TarefaPrioridadeService } from './model/TarefaPrioridade.service';
import { PerfilService } from '../../../services/Requisicoes/perfil.service';
import { Usuario } from '../../../model/Usuario';
import { Documento } from '../../../model/Documento';
import { DocumentoService } from '../../../services/documento.service';

@Component({
  selector: 'app-modal-tarefa',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, CommonModule, DropdownClassificacaoComponent, DropdownEtapaComponent, DropdownPrioridadeComponent, DropdownStatusComponent],
  templateUrl: './modal-tarefa.component.html',
})

export class ModalTarefa implements OnInit {
  tarefaForm: FormGroup;
  alterar: boolean = false;
  tarefaSelecionada: Tarefa | null = null;
  usuarioAtual!: Usuario;
  arquivos: File[] = [];
  documentos: Documento[] = [];

  constructor(
    public modalService: ModalService,
    public themeService: ThemeService,
    private fb: FormBuilder,
    private tarefaService: TarefasService,
    private documentoService: DocumentoService,
    private perfilService: PerfilService,
    public dropdownService: DropdownService,
    private classificacaoService: TarefaClassificacaoService,
    private etapaService: TarefaEtapaService,
    private statusService: TarefaStatusService,
    private prioridadeService: TarefaPrioridadeService
  ) {
    this.tarefaForm = this.fb.group({
      id: [0],
      projetoId: [null, Validators.required],
      titulo: ['', Validators.required],
      descricao: ['', Validators.required],
      status: ['', Validators.required],
      prioridade: ['', Validators.required],
      etapa: ['', Validators.required],
      classificacao: ['', Validators.required],
      ultimaAtualizacaoEm: [new Date()],
      ultimaAtualizacaoPor: [''],
      criacaoEm: [new Date()],
      criacaoPor: [''],
      dataInicio: [null, Validators.required],
      dataFim: [null, Validators.required]
    });
  }

  ngOnInit() {
    this.tarefaService.tarefaSelecionada$.subscribe((tarefa) => {
      this.tarefaSelecionada = tarefa;
      this.patchForm();
    });

    this.perfilService.getDadosUsuario().subscribe(usuario => {
      if (usuario) this.usuarioAtual = usuario;
    });
  }

  private patchForm() {
    if (this.tarefaSelecionada) {
      this.alterar = true;
      this.classificacaoService.selecionarClassificacao(this.tarefaSelecionada.classificacao);
      this.prioridadeService.selecionarPrioridade(this.tarefaSelecionada.prioridade);
      this.statusService.selecionarStatus(this.tarefaSelecionada.status);
      this.etapaService.selecionarEtapa(this.tarefaSelecionada.etapa);
      this.tarefaForm.patchValue(this.tarefaSelecionada);

      this.documentoService.getDocumentosPorTarefa(this.tarefaSelecionada.id).subscribe({
        next: (documentos) => this.documentos = documentos,
        error: (err) => console.error('Erro ao buscar documentos da tarefa:', err)
      });
    }
  }

  salvarTarefa() {
    const infoProjeto = JSON.parse(localStorage.getItem('infoProjeto') || '{}');
    const tarefa: Tarefa = this.tarefaForm.value;
  
    tarefa.projetoId = infoProjeto.id;
    tarefa.classificacao = this.classificacaoService.getClassificacaoSelecionada()();
    tarefa.etapa = this.etapaService.getEtapaSelecionada()();
    tarefa.status = this.statusService.getStatusSelecionado()();
    tarefa.prioridade = this.prioridadeService.getPrioridadeSelecionada()();
    tarefa.ultimaAtualizacaoEm = new Date().toLocaleString('sv-SE');
    tarefa.ultimaAtualizacaoPor = this.usuarioAtual.nome;
  
    if (this.alterar) {
      this.tarefaService.atualizarTarefa(tarefa).subscribe({
        next: () => this.fecharModal(),
        error: (err) => console.error('Erro ao atualizar tarefa:', err)
      });
    } else {
      tarefa.criacaoEm = new Date().toLocaleString('sv-SE');
      tarefa.criacaoPor = this.usuarioAtual.nome;
  
      this.tarefaService.adicionarTarefa(tarefa).subscribe({
        next: (tarefaSalva) => {
          if (this.arquivos.length > 0) this.uploadArquivos(tarefaSalva.id); // 👈 envia id correto
          this.fecharModal();
        },
        error: (err) => console.error('Erro ao salvar tarefa:', err)
      });
    }
  }

  uploadArquivos(tarefaId: number) {
    const infoProjeto = JSON.parse(localStorage.getItem('infoProjeto') || '{}');
  
    this.arquivos.forEach(arquivo => {
      const formData = new FormData();
      formData.append('titulo', arquivo.name);
      formData.append('escopo', 'TAREFA');
      formData.append('tipo', arquivo.type.toLocaleUpperCase());
      formData.append('tarefaid', tarefaId.toString());
      formData.append('projetoid', infoProjeto.id);
      formData.append('arquivo', arquivo);
  
      console.log('Enviando arquivo:', {
        nome: arquivo.name,
        tipo: arquivo.type,
        tarefaId,
        projetoId: infoProjeto.id,
        formDataEntries: Array.from((formData as any).entries())
      });
  
      this.documentoService.uploadDocumento(formData).subscribe({
        next: (res) => console.log('Arquivo salvo com sucesso:', res),
        error: (err) => console.error('Erro ao salvar arquivo:', err)
      });
    });
  }

  deletarTarefa() {
    this.modalService.fechar('modalTarefa');
    this.tarefaService.deletarTarefa();
  }

  fecharModal() {
    this.modalService.fechar('modalTarefa');
    this.limparFormulario();
  }

  limparFormulario() {
    this.tarefaForm.reset();
    this.tarefaService.removerSelecaoTarefa();
    this.classificacaoService.limparClassificacao();
    this.etapaService.limparEtapa();
    this.statusService.limparStatus();
    this.prioridadeService.limparPrioridade();
    this.alterar = false;
    this.documentos = [];
    this.arquivos = [];
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files) {
      const novosArquivos = Array.from(input.files);
      const nomesExistentes = new Set(this.arquivos.map(f => f.name));

      novosArquivos.forEach(file => {
        if (!nomesExistentes.has(file.name)) {
          this.arquivos.push(file);
        }
      });
    }
  }

  getExtensaoArquivo(nome: string): string {
    const partes = nome.split('.');
    return partes.length > 1 ? partes.pop()?.toLowerCase() || '' : '';
  }



  getIconePorExtensao(extensao: string): string {
    switch (extensao) {
      case 'pdf': return '../../../../assets/img/pdf.png';
      case 'doc':
      case 'docx': return '../../../../assets/img/doc.png';
      case 'xls':
      case 'xlsx': return '../../../../assets/img/xls.png';
      case 'png':
      case 'jpg':
      case 'jpeg': return '../../../../assets/img/jpg.png';
      case 'zip':
      case 'rar': return '../../../../assets/img/zip.png';
      default: return '../../../../assets/img/dafault.png';
    }
  }

  removerArquivo(arquivo: File): void {
    this.arquivos = this.arquivos.filter(a => a !== arquivo);
  }
}