import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  private modais = new Map<string, BehaviorSubject<boolean>>();

  constructor() {}

  abrir(modalId: string) {
    if (!this.modais.has(modalId)) {
      this.modais.set(modalId, new BehaviorSubject<boolean>(false));
    }
    this.modais.get(modalId)?.next(true);
    document.body.style.overflow = 'hidden'; // Impede o scroll
  }

  fechar(modalId: string) {
    if (this.modais.has(modalId)) {
      this.modais.get(modalId)?.next(false);
    }
    document.body.style.overflow = ''; // Libera o scroll
  }

  isVisivel(modalId: string): boolean {
    return this.modais.get(modalId)?.getValue() ?? false;
  }
}
  