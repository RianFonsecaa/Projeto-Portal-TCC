import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  private modais = new Map<string, boolean>();

  abrir(modalId: string){
    this.modais.set(modalId, true);
  }

  fechar(modalId: string){
    this.modais.set(modalId, false);
  }

  isVisivel(modalId: string): boolean {
    return this.modais.get(modalId) ?? false;
  }
}