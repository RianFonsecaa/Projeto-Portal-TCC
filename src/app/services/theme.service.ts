import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root', // Disponibiliza o serviço globalmente
})
export class ThemeService {
  private isDarkMode = false;

  constructor() {
    this.isDarkMode = localStorage.getItem('theme') === 'dark';
    this.applyTheme();
  }

  toggleTheme() {
    this.isDarkMode = !this.isDarkMode;
    localStorage.setItem('theme', this.isDarkMode ? 'dark' : 'light');
    this.applyTheme();
  }

  isDarkTheme(): boolean {
    return this.isDarkMode;
  }

  private applyTheme() {
    if (this.isDarkMode) {
      document.body.classList.add('dark');
    } else {
      document.body.classList.remove('dark');
    }
  }
}