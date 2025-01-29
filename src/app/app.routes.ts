import { Routes } from '@angular/router';
import { MensagensComponent } from './pages/mensagens/mensagens.component';
import { DocumentosEFormulariosComponent } from './pages/documentos-e-formularios/documentos-e-formularios.component';
import { AgendaComponent } from './pages/agenda/agenda.component';
import { HomeComponent } from './pages/home/home.component';

export const routes: Routes = [
    { path: "", component: HomeComponent },
    { path: 'agenda', component: AgendaComponent },
    { path: 'documentos-formularios', component: DocumentosEFormulariosComponent },
    { path: 'mensagens', component: MensagensComponent }
];