import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Documento } from '../../model/Documentos';
import { DocumentoService } from '../../services/documento.service';

@Component({
  selector: 'app-banco-documentos',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './banco-documentos.component.html'
})
export class BancoDocumentosComponent {
  documents: Document[] = [];

  documento: Documento[] = [];
  filtrosDocumentos: Documento[] = [];
  opcoes: string[] = ['Nome do Arquivo', 'Código da Tarefa'];
  palavraChave = '';
  campoSelecionado = '';

  mostrarPrimeiroCampo = true;

  constructor(private documentoService: DocumentoService) {
    this.documento = this.documentoService.getDocuments();  
  }

  ngOnInit(): void {
   // this.carregaDocumentos();
    this.filtrosDocumentos = [...this.documento];
    this.preencherIcone();
  }

  pesquisar() {
    if (!this.palavraChave) {
      this.filtrosDocumentos = [...this.documento];
      return;
    }

    this.filtrosDocumentos = this.documento.filter(doc => 
      doc.nome.toLowerCase().includes(this.palavraChave.toLowerCase()) ||
      doc.codigoTarefa.toLowerCase().includes(this.palavraChave.toLowerCase())
    );
  }

  preencherIcone(){
    this.documento.forEach(doc => {
      doc.tipoDoc = this.getIcon(doc.nome);
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
    this.documentoService.getDocumentos().subscribe({
      next: (docs: Documento[]) => {
        this.documento = docs; 
      },
      error: (err) => {
        console.error('Erro ao carregar documentos:', err);
      }
    });
  }

  removerCampo(){
    this.mostrarPrimeiroCampo = false;
  }

  restaurarCampo() {
      this.mostrarPrimeiroCampo = true;
  }

}
