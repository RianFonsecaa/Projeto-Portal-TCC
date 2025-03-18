import { Tarefa } from './../../../model/Tarefa';
import { Component, EventEmitter, Output } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { FormBuilder, ReactiveFormsModule, FormsModule, FormGroup, Validators } from '@angular/forms';
import { TarefasService } from '../../../services/Requisicoes/tarefas.service';
import { infoProjeto } from '../../../model/infoProjeto';
import { Subscription } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-modal-tarefa',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, CommonModule],
  templateUrl: './modal-tarefa.component.html',
})
export class ModalTarefa {
  classificacoes = [
    { nome: 'Bibliografia' },
    { nome: 'Redação' },
    { nome: 'Desenvolvimento' },
    { nome: 'Manutenção' },
    { nome: 'Pesquisa' },
    { nome: 'Estudo' },
    { nome: 'Planejamento' },
    { nome: 'Revisão' },
    { nome: 'Documentação' },
    { nome: 'Apresentação' }
  ];

  classificacoesMap: { [key: string]: string } = {
    BIBLIOGRAFIA: 'Bibliografia',
    REDACAO: 'Redação',
    DESENVOLVIMENTO: 'Desenvolvimento',
    MANUTENCAO: 'Manutenção',
    PESQUISA: 'Pesquisa',
    ESTUDO: 'Estudo',
    PLANEJAMENTO: 'Planejamento',
    REVISAO: 'Revisão',
    DOCUMENTACAO: 'Documentação',
    APRESENTACAO: 'Apresentação',
  };

  dropdownVisible: boolean = false;
  isRotated: boolean = false;
  infoProjeto: infoProjeto = {} as infoProjeto;
  tarefaForm: FormGroup;
  private subscription: Subscription | null = null;
  alterar: boolean = false;

  constructor(
    public modalService: ModalService,
    public themeService: ThemeService,
    private fb: FormBuilder,
    private tarefaService: TarefasService
  ) {
    this.tarefaForm = this.fb.group({
      id: [0],
      nomeTarefa: ['', Validators.required],
      descricao: ['', Validators.required],
      prioridade: ['', Validators.required],
      status: ['', Validators.required],
      classificacao: ['', Validators.required],
      prazo: ['', Validators.required]
    });

    this.infoProjeto = JSON.parse(localStorage.getItem('infoProjeto') || '{}');
  }

  ngOnInit() {
    this.subscription = this.tarefaService.tarefaSelecionada$.subscribe(tarefa => {
      if (tarefa) {
        console.log(tarefa);
        this.alterar = true;

        this.tarefaForm.patchValue({
          id: tarefa.id,
          nomeTarefa: tarefa.nomeTarefa,
          descricao: tarefa.descricao,
          prioridade: tarefa.prioridade,
          status: tarefa.status,
          classificacao: this.classificacoesMap[tarefa.classificacao],
          prazo: tarefa.prazo
        });
      } else {
        this.tarefaForm.reset({
          classificacao: ''
        });
        this.alterar = false;
      }
    });
  }

  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
    this.isRotated = !this.isRotated;
  }

  salvarTarefa() {

    if (this.tarefaForm.value.status === null || this.tarefaForm.value.status === '') {
      this.tarefaForm.value.status = 'BACKLOG';
    }

    const tarefa: Tarefa = this.tarefaForm.value;
    tarefa.projetoId = this.infoProjeto.id;
    console.log(tarefa)
    console.log(this.alterar)
    if (this.alterar) {
      this.tarefaService.atualizarTarefa(tarefa);
    } else {

      this.tarefaService.adicionarTarefa(tarefa);
    }

    this.fecharModal();
  }

  deletarTarefa(){
    this.modalService.fechar('modalTarefa');
    this.tarefaService.deletarTarefa();
  }

  fecharModal() {
    this.modalService.fechar('modalTarefa');
    this.limparFormulario();
  }

  limparFormulario() {

    this.tarefaForm.reset({
      classificacao: ''
    });
    this.alterar = false;
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
