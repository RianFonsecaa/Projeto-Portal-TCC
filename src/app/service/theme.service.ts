import { HostBinding, Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  darkMode = signal<boolean>(false);

  toggleDarkMode() {
    this.darkMode.set(!this.darkMode());
    this.atualizarClasseNoBody();
  }

  private atualizarClasseNoBody() {
    if (this.darkMode()) {
      document.body.classList.add('dark');
    } else {
      document.body.classList.remove('dark');
    }
  }
}
