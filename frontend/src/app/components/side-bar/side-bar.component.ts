import { NgClass, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [NgClass, RouterLink],
  templateUrl: './side-bar.component.html',
})
export class SideBarComponent {

  constructor(private router: Router) { }

  isActiveRoute(route: string): boolean {
    return this.router.url === route;
  }

}
