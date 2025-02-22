import { Component } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-modal-perfil-orientador',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule],
  templateUrl: './modal-perfil-orientador.component.html',
})
export class ModalPerfilOrientadorComponent {
  perfilUsuario = {
    areaPesquisa: 'Inteligência Artificial e Machine Learning',
    telefone: '(75) 91234-5678',
    email: 'exemplo321@gmail.com',
    cargo: 'Professor efetivo',
    disponibilidadeOrientacao: 'Aceitando',
    projetosEmOrientacao: '6'
  };

  isDisabled: boolean = true;
  perfilForm: FormGroup;

  constructor(
    public modalService: ModalService, 
    public themeService: ThemeService,
    private fb: FormBuilder
  ) {
    this.perfilForm = this.fb.group({
      areaPesquisa: [this.perfilUsuario.areaPesquisa],
      telefone: [this.perfilUsuario.telefone],
      email: [this.perfilUsuario.email],
      cargo: [this.perfilUsuario.cargo],
      disponibilidadeOrientacao: [this.perfilUsuario.disponibilidadeOrientacao],
      projetosEmOrientacao: [this.perfilUsuario.projetosEmOrientacao]
    });

    this.perfilForm.disable();
  }

  toggleEdicao() {
    this.isDisabled = !this.isDisabled;

    if (this.isDisabled) {
      this.perfilForm.disable();
      this.perfilForm.patchValue({
        areaPesquisa: this.perfilUsuario.areaPesquisa,
        telefone: this.perfilUsuario.telefone,
        email: this.perfilUsuario.email,
        cargo: this.perfilUsuario.cargo,
        disponibilidadeOrientacao: this.perfilUsuario.disponibilidadeOrientacao,
        projetosEmOrientacao: this.perfilUsuario.projetosEmOrientacao
      });
    } else {
      this.perfilForm.enable();

    }
  }

  fecharModal(){
    this.toggleEdicao();
    this.modalService.fechar('modalPerfilOrientador');
  }
}