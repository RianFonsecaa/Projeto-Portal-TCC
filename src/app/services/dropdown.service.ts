import { Injectable, Signal } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DropdownService {
  private dropdowns = new Map<string, BehaviorSubject<boolean>>();

  toggle(dropdownId: string) {
    if (!this.dropdowns.has(dropdownId)) {
      this.dropdowns.set(dropdownId, new BehaviorSubject<boolean>(false));
    }

    const estadoAtual = this.dropdowns.get(dropdownId)!.getValue();
    
    this.fecharTodosDropdowns(dropdownId);

    this.dropdowns.get(dropdownId)!.next(!estadoAtual);

    console.log(`Dropdown ${dropdownId} toggled. Novo estado: ${!estadoAtual}`);
  }

  private fecharTodosDropdowns(dropdownIdExcecao: string) {
    this.dropdowns.forEach((subject, key) => {
      if (key !== dropdownIdExcecao && subject.getValue()) {
        subject.next(false);
        console.log(`Dropdown ${key} fechado`);
      }
    });
  }

  isVisivel(dropdownId: string): boolean {
    return this.dropdowns.get(dropdownId)?.getValue() ?? false;
  }
}