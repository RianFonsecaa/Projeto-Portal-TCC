import { Injectable, Signal } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  private modais = new Map<string, BehaviorSubject<boolean>>();

  abrir(modalId: string) {
    if (!this.modais.has(modalId)) {
      this.modais.set(modalId, new BehaviorSubject<boolean>(false)); // Inicializa com false
    }
    this.modais.get(modalId)?.next(true); // Muda para 'true' quando o modal é aberto
  }

  fechar(modalId: string) {
    if (this.modais.has(modalId)) {
      this.modais.get(modalId)?.next(false); // Muda para 'false' quando o modal é fechado
    }
  }

  isVisivel(modalId: string): boolean {
    return this.modais.get(modalId)?.getValue() ?? false; // Retorna o valor atual, ou 'false' se não existir
  }

  // Método para escutar a visibilidade de um modal
  getModalVisibility(modalId: string) {
    if (!this.modais.has(modalId)) {
      this.modais.set(modalId, new BehaviorSubject<boolean>(false)); // Inicializa com false, caso não tenha sido aberto
    }
    return this.modais.get(modalId)?.asObservable(); // Retorna um Observable
  }
}