import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Documento } from '../../model/Documento';
import { DocumentoService } from '../../services/documento.service';

@Component({
  selector: 'app-banco-documentos',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './banco-documentos.component.html'
})
export class BancoDocumentosComponent {
  documents: Document[] = [];

  documentos: Documento[] = [];
  filtrosDocumentos: Documento[] = [];
  opcoes: string[] = ['Nome do Arquivo', 'Código da Tarefa'];
  palavraChave = '';
  campoSelecionado = '';

  mostrarPrimeiroCampo = true;

  constructor(private documentoService: DocumentoService) {
    this.documentos = this.documentoService.getDocumentos();  
  }

  ngOnInit(): void {
   // this.carregaDocumentos();
    this.filtrosDocumentos = [...this.documentos];
    this.preencherIcone();
  }

  pesquisar() {
    if (!this.palavraChave) {
      this.filtrosDocumentos = [...this.documentos];
      return;
    }

    this.filtrosDocumentos = this.documentos.filter(doc => 
      doc.titulo.toLowerCase().includes(this.palavraChave.toLowerCase()) ||
      doc.tarefaId.toLowerCase().includes(this.palavraChave.toLowerCase())
    );
  }

  preencherIcone(){
    this.documentos.forEach(doc => {
      doc.tipoDocumento = this.getIcon(doc.titulo);
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

  private carregaDocumentos(): void {
   this.documentos = this.documentoService.getDocumentos()
  }

  removerCampo(){
    this.mostrarPrimeiroCampo = false;
  }

  restaurarCampo() {
      this.mostrarPrimeiroCampo = true;
  }

}
