import { NgFor, NgIf } from '@angular/common';
import { Component, ElementRef, EventEmitter, HostListener, inject, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

interface SelectItem {
  name: string;
  image?: string;
  email?: string;
  role?: string;
  selected: boolean;
  color?: string; // Propriedade para armazenar a cor
}

@Component({
  selector: 'app-single-select',
  standalone: true,
  imports: [NgIf, NgFor, CommonModule],
  templateUrl: './single-select.component.html',
})
export class SingleSelectComponent {
  @Input() items: SelectItem[] = [];
  @Input() placeholder: string = 'Escolha uma opção'; // Placeholder personalizável
  @Output() selectionChange = new EventEmitter<SelectItem[]>();

  private elementRef = inject(ElementRef);
  isDropdownVisible = false;
  filteredItems: SelectItem[] = [];

  ngOnInit() {
    this.filteredItems = this.items;
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    if (!this.elementRef.nativeElement.contains(event.target)) {
      this.isDropdownVisible = false;
    }
  }

  resetSelection() {
    // Limpar seleção dos itens
    this.items.forEach(item => item.selected = false);
    this.selectionChange.emit([]); // Emitir um array vazio para limpar a seleção no componente pai
  }

  filterItems(event: Event) {
    const searchItem = (event.target as HTMLInputElement).value.toLowerCase();
    this.filteredItems = this.items.filter(item => item.name.toLowerCase().includes(searchItem));
  }

  toggleItem(selectedItem: SelectItem, event: MouseEvent) {
    event.stopPropagation();
    // Desmarcar todos os itens
    this.items.forEach(item => {
      item.selected = false; // Desmarcar todos os itens
    });
    // Selecionar apenas o item clicado
    selectedItem.selected = true; // Marcar o item clicado como selecionado
    this.selectionChange.emit(this.items.filter(i => i.selected));
  }

  removeItem(item: SelectItem, event: MouseEvent) {
    event.stopPropagation();
    item.selected = false; // Desmarcar o item ao remover
    this.selectionChange.emit(this.items.filter(i => i.selected));
  }

  showDropdown() {
    this.isDropdownVisible = true;
  }

  isEmptySelection(): boolean {
    return !this.items.some(item => item.selected);
  }

  getSelectedColor(): string {
    const selectedItem = this.items.find(item => item.selected);
    return selectedItem?.color ?? ''; // Usar a cor do item selecionado ou 'transparent' se nenhum estiver selecionado
  }
}
