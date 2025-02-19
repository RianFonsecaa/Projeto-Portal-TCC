import { NgClass, NgIf, NgStyle } from '@angular/common';
import { Component, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-base-modal',
  standalone: true,
  imports: [NgIf, NgClass, NgStyle],
  templateUrl: './base-modal.component.html',
})
export class BaseModalComponent {
  isModalOpen: boolean = false;
  @Input() leftPosition: string = '';
  @Input() topPosition: string = '';

  constructor() { }

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }
}
