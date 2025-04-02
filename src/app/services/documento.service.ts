import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Documento } from '../model/Documentos';


@Injectable({
  providedIn: 'root'
})
export class DocumentoService {

  private readonly apiUrl = `${environment.documentosUrl}/documents`;

  constructor(private http: HttpClient) {}

  private documents: Documento[] = [
    { nome: 'Artigo_introducao_Tecnologio.pdf', data: '2025-03-20 14:32:00', tamanho: '2.5 MB', codigoTarefa: 'A285C4' },
    { nome: 'Planilha_Controle_Financeiro.xlsx', data: '2025-03-21 09:45:15', tamanho: '1.2 MB', codigoTarefa: 'D7FI69' },
    { nome: 'Tec_Anterior_Aluno_2022.pdf', data: '2025-03-22 10:00:50', tamanho: '2.5 MB', codigoTarefa: 'H3K9J2' },
    { nome: 'Pesquisa_Tecnologia_Sustentabilidade.pdf', data: '2025-03-22 15:20:34', tamanho: '3.1 MB', codigoTarefa: 'A285C4' },
    { nome: 'Modelo_Escrita_Resumo.pptx', data: '2025-03-23 11:18:28', tamanho: '5.0 MB', codigoTarefa: 'F4DBT3' },
    { nome: 'Documento_Apolo_Metodologia.docx', data: '2025-03-24 08:30:00', tamanho: '3.7 MB', codigoTarefa: 'VIR7Y2' },
    { nome: 'Estudo_Caso_Descifos_Industriais.pdf', data: '2025-03-25 13:50:12', tamanho: '2.0 MB', codigoTarefa: 'VIR7Y2'}
  ];

  getDocuments(): Documento[] {
    return this.documents;
  }

  filterDocuments(keyword: string, field: string): Documento[] {
    if (!keyword) return this.documents;
    
    return this.documents.filter(doc => 
      doc.nome.toLowerCase().includes(keyword.toLowerCase()) ||
      doc.codigoTarefa.toLowerCase().includes(keyword.toLowerCase())
    );
  }

  getDocumentos(): Observable<Documento[]> {
    return this.http.get<Documento[]>(this.apiUrl);
  }

}