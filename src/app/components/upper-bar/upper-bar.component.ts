import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {

  iconColor: String = '#515151'

  toggleTheme(toggleButton: HTMLElement) {
    if (toggleButton.classList.contains('translate-x-10')) {
      toggleButton.classList.remove('translate-x-10');
      toggleButton.classList.add('translate-x-0');
      this.iconColor = '#515151'
    } else {
      toggleButton.classList.remove('translate-x-0');
      toggleButton.classList.add('translate-x-10');
      this.iconColor = '#61B668'
    }
  }
}
