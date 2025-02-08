import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root', // Disponibiliza o serviço globalmente
})
export class ThemeService {
  private isDarkMode = false; // Estado do tema

  constructor() {
    // Verifica o tema salvo no localStorage ao inicializar
    this.isDarkMode = localStorage.getItem('theme') === 'dark';
    this.applyTheme();
  }

  // Alterna entre os temas
  toggleTheme() {
    this.isDarkMode = !this.isDarkMode;
    localStorage.setItem('theme', this.isDarkMode ? 'dark' : 'light');
    this.applyTheme();
  }

  // Retorna o estado atual do tema
  isDarkTheme(): boolean {
    return this.isDarkMode;
  }

  // Aplica o tema ao body
  private applyTheme() {
    if (this.isDarkMode) {
      document.body.classList.add('dark'); // Adiciona a classe 'dark' ao body
    } else {
      document.body.classList.remove('dark'); // Remove a classe 'dark' do body
    }
  }
}