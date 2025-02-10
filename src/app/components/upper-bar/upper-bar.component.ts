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
  menuOpen: boolean = false;

  constructor(public themeService: ThemeService) { }

  toggleDarkMode() {
    this.themeService.toggleDarkMode();
  }


}
