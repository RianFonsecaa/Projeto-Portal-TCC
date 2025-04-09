import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Documento } from '../model/Documento';


@Injectable({
  providedIn: 'root'
})
export class DocumentoService {
  private readonly apiUrl = `${environment.documentosUrl}`;

  constructor(private http: HttpClient) {}

  private documents: Documento[] = [];

  getDocumentos(): Documento[] {
    return this.documents;
  }

  filterDocuments(keyword: string, field: string): Documento[] {
    if (!keyword) return this.documents;

    return this.documents.filter(doc => 
      doc.titulo.toLowerCase().includes(keyword.toLowerCase()) ||
      doc.tarefaId.toString().includes(keyword)
    );
  }

  uploadDocumento(formData: FormData): Observable<Documento> {
    console.log(formData.get)
    return this.http.post<Documento>(`${environment.documentosUrl}/upload`, formData);
  }

  getDocumentosPorTarefa(tarefaId: number): Observable<Documento[]> {
    return this.http.get<Documento[]>(`${this.apiUrl}/tarefa/${tarefaId}`);
  }

  deletarDocumento(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

}
