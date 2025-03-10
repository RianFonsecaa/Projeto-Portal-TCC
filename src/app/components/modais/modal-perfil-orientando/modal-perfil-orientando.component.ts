import { Component, Input } from '@angular/core';
import { Usuario } from '../../../model/Usuario';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass, NgIf } from '@angular/common';

@Component({
  selector: 'app-modal-perfil-orientando',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, NgIf],
  templateUrl: './modal-perfil-orientando.component.html',
})
export class ModalPerfilOrientandoComponent {
  @Input() perfilUsuario!: Usuario;

  isDisabled: boolean = true;
  perfilForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    public modalService: ModalService,
    public themeService: ThemeService
  ) {
    this.perfilForm = this.fb.group({
      email: new FormControl({ disabled: false }),
      telefone: new FormControl({ disabled: false }),
      tipoUsuario: new FormControl({ disabled: false }),
      curso: new FormControl({ disabled: false})
    });
    this.perfilForm.disable();
  }

  ngOnChanges(): void {
    this.carregaValues();
  }

  carregaValues() {
    if (this.perfilUsuario && Object.keys(this.perfilUsuario).length) {
      this.perfilForm.patchValue({
        email: this.perfilUsuario.email,
        telefone: this.perfilUsuario.telefone,
        tipoUsuario: this.perfilUsuario.tipoUsuario,
        curso: this.perfilUsuario.tipoCurso,
      });
    }
    this.aplicarRegexTelefone();
  }

  abrirModal(): void {
    this.modalService.abrir('modalPerfilOrientando');
    this.aplicarRegexTelefone();
  }

  fecharModal(): void {
    this.modalService.fechar('modalPerfilOrientando');
  }

  aplicarRegexTelefone(): void {
    const telefoneValue = this.perfilForm.get('telefone')?.value;
    if (telefoneValue) {
      const telefoneFormatado = telefoneValue.replace(/(\d{2})(\d{5})(\d{4})/, '($1) $2-$3');
      this.perfilForm.get('telefone')?.setValue(telefoneFormatado);
    }
  }
}

