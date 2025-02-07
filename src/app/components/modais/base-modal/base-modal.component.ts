import { NgClass, NgIf } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-base-modal',
  standalone: true,
  imports: [NgIf, NgClass],
  templateUrl: './base-modal.component.html',
})
export class BaseModalComponent {
  isModalOpen: boolean = false;

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }

}
