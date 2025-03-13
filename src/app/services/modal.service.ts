import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Tarefa } from '../model/Tarefa';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  private modais = new Map<string, BehaviorSubject<boolean>>();
  private tarefaSelecionada = new BehaviorSubject<Tarefa | null>(null);
  tarefaSelecionada$ = this.tarefaSelecionada.asObservable();

  constructor() {}

  abrir(modalId: string, tarefa?: Tarefa) {
    if (!this.modais.has(modalId)) {
      this.modais.set(modalId, new BehaviorSubject<boolean>(false));
    }

    if (tarefa) {
      this.tarefaSelecionada.next(tarefa);
    }

    this.modais.get(modalId)?.next(true);
  }

  fechar(modalId: string) {
    if (this.modais.has(modalId)) {
      this.modais.get(modalId)?.next(false);
    }
    this.tarefaSelecionada.next(null);
  }

  isVisivel(modalId: string): boolean {
    return this.modais.get(modalId)?.getValue() ?? false;
  }

  getModalVisibility(modalId: string) {
    if (!this.modais.has(modalId)) {
      this.modais.set(modalId, new BehaviorSubject<boolean>(false));
    }
    return this.modais.get(modalId)?.asObservable();
  }
}
