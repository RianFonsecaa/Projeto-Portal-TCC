import { NgFor, NgIf } from '@angular/common';
import { Component, ElementRef, EventEmitter, HostListener, inject, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
interface SelectItem {
  name: string;
  image?: string;
  email?: string;
  role?: string;
  selected: boolean;
}

@Component({
  selector: 'app-multi-select',
  standalone: true,
  imports: [NgIf, NgFor, CommonModule],
  templateUrl: './multi-select.component.html',
  styleUrl: './multi-select.component.css'
})
export class MultiSelectComponent {
  @Input() items: SelectItem[] = []
  @Output() selectionChange = new EventEmitter<SelectItem[]>();

  private elementRef = inject(ElementRef)
  isDropdownVisible = false
  filteredItems: SelectItem[] = []

  isEmptySelection(): boolean {
    return !this.items.some(item => item.selected);
  }

  ngOnInit() {
    this.filteredItems = this.items
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    if (!this.elementRef.nativeElement.contains(event.target)) {
      this.isDropdownVisible = false
    }
    }

  filterItems(event: Event) {
    const searchItem = (event.target as HTMLInputElement).value.toLocaleLowerCase();
    this.filteredItems = this.items.filter(item => item.name.toLowerCase().includes(searchItem))
  }

  toggleItem(item: SelectItem, event: MouseEvent) {
    event.stopPropagation()
    item.selected = !item.selected
    this.selectionChange.emit(this.items.filter(i => i.selected))
  }

  removeItem(item: SelectItem, event: MouseEvent) {
    event.stopPropagation()
    item.selected = false
    this.selectionChange.emit(this.items.filter(i => i.selected))
  }

  showDropdown() {
    this.isDropdownVisible = true
  }

}
