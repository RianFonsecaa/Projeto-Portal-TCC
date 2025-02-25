import { Injectable } from '@angular/core';
import { Demanda } from '../model/AlunoDemanda';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DemandasService {
  private apiUrl = 'http://localhost:8080/api/tarefas';
  private demandas: Demanda[] = [];

  constructor(private http: HttpClient) {
    this.carregarDemandas();
    console.log('demandas: '+this.demandas)
  }

  private demandasSubject = new BehaviorSubject<Demanda[]>([]);
  demandas$ = this.demandasSubject.asObservable(); 
 

  private carregarDemandas() {
    this.http.get<Demanda[]>(this.apiUrl).subscribe(demandas => {
      this.demandasSubject.next(demandas);
    });
  }

  adicionarDemanda(demanda: Demanda): Observable<Demanda> {
    return this.http.post<Demanda>(this.apiUrl, demanda);
  }

  atualizarStatus(id: number, novoStatus: string): void {
    const demandasAtuais = this.demandasSubject.value;
    const demandaIndex = demandasAtuais.findIndex(d => d.id === id);
    if (demandaIndex !== -1) { //caso nao encontre o id da demanda ele retorna false
      demandasAtuais[demandaIndex].status = novoStatus;
      this.demandasSubject.next([...demandasAtuais]);
    }else{
      alert('Demanda não encontrada !');
    }
  }
  getDemandas(): Observable<Demanda[]> {
    return of(this.demandas); 
  }

  getDemandasPorStatus(status: string): Demanda[] {
    return this.demandasSubject.value.filter(d => d.status === status);
  }

  getDemandasPorIdProjeto(idProjeto: number): Observable<Demanda[]> {
    const url = `${this.apiUrl}/projeto/${idProjeto}`;
    return this.http.get<Demanda[]>(url);
  }
  
  
}
