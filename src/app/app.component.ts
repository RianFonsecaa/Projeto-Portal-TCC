import { Component } from '@angular/core';
import { LoginComponent } from './pages/login.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [LoginComponent],
  templateUrl: './app.component.html',
  styleUrls: []
})
export class AppComponent {
  title = 'Projeto';
}
