import { Routes } from '@angular/router';
import { MensagensComponent } from './pages/mensagens/mensagens.component';
import { DocumentosEFormulariosComponent } from './pages/documentos-e-formularios/documentos-e-formularios.component';
import { AgendaComponent } from './pages/agenda/agenda.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { DashboardOrientadorComponent } from './pages/dashboard-orientador/dashboard-orientador.component';
import { DashboardAlunoComponent } from './pages/dashboard-aluno/dashboard-aluno.component';

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' }, // Correção aqui
    {
        path: 'home',
        component: HomeComponent,
        children: [
            { path: 'dashboardOrientador', component: DashboardOrientadorComponent, outlet: 'dashboard' },
            { path: 'dashboardAluno', component: DashboardAlunoComponent, outlet: 'dashboard' },
            { path: 'agenda', component: AgendaComponent, outlet: 'dashboard' },
            { path: 'documentos-formularios', component: DocumentosEFormulariosComponent, outlet: 'dashboard' },
            { path: 'mensagens', component: MensagensComponent, outlet: 'dashboard' }
        ]
    },
    { path: 'login', component: LoginComponent }
];
