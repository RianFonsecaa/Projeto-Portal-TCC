
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { UpperBarComponent } from "../../components/upper-bar/upper-bar.component";
import { SideBarComponent } from "../../components/side-bar/side-bar.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, UpperBarComponent, SideBarComponent],
  templateUrl: './home.component.html'
})
export class HomeComponent {
  title = 'teacher-dashboard';
}
