import { NgIf } from '@angular/common';
import { Component, ElementRef, HostListener, ViewChild } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ThemeService } from '../../services/theme.service';

@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgIf],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {

  @ViewChild('toggleButton') toggleButton!: ElementRef;
  menuOpen: boolean = false;

  constructor(private themeService: ThemeService) { }


  ngOnInit() {
    this.themeService.isDarkTheme;
  }

  toggle() {
    this.themeService.toggleTheme();
    this.updateButtonPosition();
  }
  get isDarkMode(): boolean {
    return this.themeService.isDarkTheme();
  }

  private updateButtonPosition() {
    if (this.isDarkMode) {
      this.toggleButton.nativeElement.classList.remove('translate-x-10');
      this.toggleButton.nativeElement.classList.add('translate-x-10');
    } else {
      this.toggleButton.nativeElement.classList.remove('translate-x-10');
      this.toggleButton.nativeElement.classList.add('translate-x-0');
    }
  }

  toggleMenu(event: MouseEvent) {
    event.stopPropagation();
    this.menuOpen = !this.menuOpen;
  }

  @HostListener('document:click', ['$event'])
  onClickOutside(event: MouseEvent) {
    const menuElement = document.querySelector('nav');
    const buttonElement = document.querySelector('button');

    if (menuElement && buttonElement && !menuElement.contains(event.target as Node) && !buttonElement.contains(event.target as Node)) {
      this.menuOpen = false;
    }
  }

  
}
