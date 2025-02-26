import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Aluno } from '../../model/AlunoDemanda';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {
  private apiUrl = 'https://localhost:8080/api/alunos';

  constructor(private http: HttpClient) {}

  getAlunos(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(this.apiUrl);
  }

  getAlunoById(id: number): Observable<Aluno> {
    return this.http.get<Aluno>(`${this.apiUrl}/${id}`);
  }
}
