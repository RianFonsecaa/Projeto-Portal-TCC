import { Component, Input } from '@angular/core';
import { ModalService } from '../../services/modal.service';
import { Router } from '@angular/router';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-dropdown',
  standalone: true,
  imports: [NgClass],
  templateUrl: './dropdown.component.html',
})
export class DropdownComponent {
  @Input() tipoPerfilModal: string = '';
  isVisible: boolean = false;

  constructor( public modalService: ModalService, private router: Router){
    
  }

  abrir(){
    this.isVisible = !this.isVisible;
  }

  Logout(): void {
    localStorage.clear();
    this.router.navigate(['/login']);
  }

}
