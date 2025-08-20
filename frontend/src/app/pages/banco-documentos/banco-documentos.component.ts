import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Documento } from '../../model/Documento';
import { DocumentoService } from '../../services/documento.service';
import { projetoService } from '../../services/Requisicoes/projetoService';

@Component({
  selector: 'app-banco-documentos',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './banco-documentos.component.html'
})
export class BancoDocumentosComponent {
  documentoUrl: string | null = null;

  documentos: Documento[] = [];
  filtrosDocumentos: Documento[] = [];
  opcoes: string[] = ['Nome do Arquivo', 'Escopo'];
  palavraChave = '';
  campoSelecionado = '';

  mostrarPrimeiroCampo = true;

  constructor(private documentoService: DocumentoService ,
    private projetoService: projetoService
  ) {
    
  
  }

  ngOnInit(): void {
    this.carregarDocumentosPorId();
  }

  pesquisar() {
    if (!this.palavraChave) {
      this.filtrosDocumentos = [...this.documentos];
      return;
    }

    if (this.campoSelecionado.toLowerCase() == 'escopo'){
      this.filtrosDocumentos = this.documentos.filter(doc =>
        doc.escopoDocumento.toLowerCase().includes(this.palavraChave.toLowerCase())
      )
    }

    else if (this.campoSelecionado.toLowerCase() == 'nome'){
    this.filtrosDocumentos = this.documentos.filter(doc => 
      doc.titulo.toLowerCase().includes(this.palavraChave.toLowerCase())
    )
  }
  else if(this.campoSelecionado == ''){
    this.filtrosDocumentos = this.documentos.filter(doc => 
      doc.titulo.toLowerCase().includes(this.palavraChave.toLowerCase())
    )
  }
 
  }

  preencherIcone(){
    this.documentos.forEach(doc => {
      doc.extensao = this.getIcon(doc.titulo);
    });
  }

  getIcon(nomeArquivo: string): string {
    if (!nomeArquivo) return '../../../assets/svg/pdf.svg'; 

    const ext = nomeArquivo.split('.').pop()?.toLowerCase() || '';
    
    switch(ext) {
      case 'pdf': return '../../../assets/svg/pdf.svg';
      case 'xlsx': return '../../../assets/svg/xls.svg';
      case 'xls': return '../../../assets/svg/xls.svg';
      case 'docx': return '../../../assets/svg/doc.svg';
      case 'pptx':return '../../../assets/svg/ppt.svg'
      default: return '../../../assets/svg/pdf.svg';
    }
  }

  removerCampo(){
    this.mostrarPrimeiroCampo = false;
  }

  restaurarCampo() {
      this.mostrarPrimeiroCampo = true;
  }

  carregarDocumentosPorId() {
    const infoProjeto = this.projetoService.getInfoProjeto();
    if (!infoProjeto.id) {
      console.error('Projeto não encontrado');
      return;
    }
  
    this.documentoService.listaDocumentosPorProjeto(infoProjeto.id.toString()).subscribe({
      next: (documentos) => {
        this.documentos = documentos;
        this.filtrosDocumentos = [...documentos]; 
        this.preencherIcone(); 
      },
      error: (err) => {
        console.error('Erro ao buscar documentos:', err);
      }
    });
  }

  
  abrir(url: string): void {
    window.open(url, '_blank');
  }
  
  

  abrirDocumento(url: string): void {
    if (url.startsWith('http://') || url.startsWith('https://')) {
      window.open(url, '_blank');
    } else {
      console.error('URL inválida:', url);
    }
  }
  

  ngOnDestroy(): void {
    if (this.documentoUrl) {
      URL.revokeObjectURL(this.documentoUrl);
    }
  }

  ordenar(tipo : string){
    if (tipo == 'nome'){
      this.filtrosDocumentos.sort((a,b) => a.titulo.localeCompare(b.titulo))
    }
    else if(tipo == 'data'){
      this.filtrosDocumentos.sort((a, b) => {
        return new Date(a.dataUpload!).getTime() - new Date(b.dataUpload!).getTime();
      });     
    }
    else if (tipo =='tamanho'){
      this.filtrosDocumentos.sort((a,b) => b.tamanho - a.tamanho)
    }
  }

}
