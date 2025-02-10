import { NgClass, NgIf } from '@angular/common';
import { Component, ElementRef, HostListener, ViewChild } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ThemeService } from '../../service/theme.service';

@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgIf, NgClass],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {

  @ViewChild('toggleButton') toggleButton!: ElementRef;
  menuOpen: boolean = false;

  constructor(public themeService: ThemeService) { }

  toggleDarkMode() {
    this.themeService.toggleDarkMode();
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
