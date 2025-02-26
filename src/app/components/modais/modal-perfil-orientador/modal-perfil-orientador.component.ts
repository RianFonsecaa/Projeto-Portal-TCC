import { Component, Input } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass, NgIf } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Usuario } from '../../../model/Usuario';

@Component({
  selector: 'app-modal-perfil-orientador',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, NgIf],
  templateUrl: './modal-perfil-orientador.component.html',
})
export class ModalPerfilOrientadorComponent {
  @Input() perfilUsuario!: Usuario;

  isDisabled: boolean = true;
  perfilForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    public modalService: ModalService,
    public themeService: ThemeService
  ) {
    this.perfilForm = this.fb.group({
      id: new FormControl({ disabled: false }),
      nome: new FormControl({ value: '', disabled: false }),
      email: new FormControl({ disabled: false }),
      telefone: new FormControl({ disabled: false }),
      tipoUsuario: new FormControl({ disabled: false }),
      areaPesquisa: new FormControl({ disabled: false }),
      cargo: new FormControl({ disabled: false }),
      disponibilidadeOrientacao: new FormControl({ disabled: false }),
      projetosEmOrientacao: new FormControl({ disabled: false }),
      resumo: new FormControl({ disabled: false })
    });
    this.perfilForm.disable();
  }

  ngOnChanges(): void {
    this.carregaValues();
  }

  carregaValues() {
    if (this.perfilUsuario && Object.keys(this.perfilUsuario).length) {
      this.perfilForm.patchValue({
        id: this.perfilUsuario.id,
        nome: this.perfilUsuario.nome,
        email: this.perfilUsuario.email,
        telefone: this.perfilUsuario.telefone,
        tipoUsuario: this.perfilUsuario.tipoUsuario,
        areaPesquisa: this.perfilUsuario.areaPesquisa,
        cargo: this.perfilUsuario.cargo,
        disponibilidadeOrientacao: this.perfilUsuario.orientadorDisponivel ? 'Disponível' : 'Indisponível',
        projetosEmOrientacao: this.perfilUsuario.projetosEmOrientacao,
        resumo: this.perfilUsuario.resumo
      });
    }
  }

  toggleEdicao(): void {
    this.isDisabled = !this.isDisabled;

    if (this.isDisabled) {
      this.perfilForm.disable();
      this.perfilForm.patchValue(this.perfilUsuario);
    } else {
      this.perfilForm.enable();
    }
    this.aplicarRegexTelefone();
  }

  abrirModal(): void {
    this.modalService.abrir('modalPerfilOrientador');
    this.aplicarRegexTelefone();
  }

  fecharModal(): void {
    this.isDisabled = true;
    this.perfilForm.disable();
    this.perfilForm.patchValue(this.perfilUsuario); // Garante que volta aos valores originais
    this.modalService.fechar('modalPerfilOrientador');
  }

  aplicarRegexTelefone(): void {
    const telefoneValue = this.perfilForm.get('telefone')?.value;
    if (telefoneValue) {
      const telefoneFormatado = telefoneValue.replace(/(\d{2})(\d{5})(\d{4})/, '($1) $2-$3');
      this.perfilForm.get('telefone')?.setValue(telefoneFormatado);
    }
  }
}
