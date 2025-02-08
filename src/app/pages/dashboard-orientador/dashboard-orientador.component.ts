import { CommonModule, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UpperBarComponent } from '../../components/upper-bar/upper-bar.component';
import { SideBarComponent } from '../../components/side-bar/side-bar.component';
import { TccCard } from '../../model/TccCard';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterOutlet, UpperBarComponent, SideBarComponent, NgFor],
  templateUrl: './dashboard-orientador.component.html',
})
export class DashboardOrientadorComponent {
  tccCards: TccCard[] = [
    {
      titulo: "Projeto A",
      autor: "João Silva",
      cursoAutor: "Análise e Desenvolvimento de Sistemas",
      backgroundUrl: "../../../assets/img/adem-ay-Tk9m_HP4rgQ-unsplash.jpg",
      tipoProjeto: "Pesquisa Científica",
      horasOrientacao: 45,
      demandasAtribuidas: 5,
      demandasEmAndamento: 2,
      demandasResolvidas: 3,
      dataUltimaAtualizacao: "28/01/2025",
      progresso: 45,
    },
    {
      titulo: "Projeto B",
      autor: "Maria Oliveira",
      cursoAutor: "Redes de Computadores",
      backgroundUrl: "../../../assets/img/alexandre-debieve-FO7JIlwjOtU-unsplash.jpg",
      tipoProjeto: "Desenvolvimento de Software",
      horasOrientacao: 30,
      demandasAtribuidas: 6,
      demandasEmAndamento: 3,
      demandasResolvidas: 3,
      dataUltimaAtualizacao: "26/01/2025",
      progresso: 50,
    },
    {
      titulo: "Projeto C",
      autor: "Carlos Souza",
      cursoAutor: "Produção Multimídia",
      backgroundUrl: "../../../assets/img/photo-1515879218367-8466d910aaa4.avif",
      tipoProjeto: "Pesquisa Aplicada",
      horasOrientacao: 60,
      demandasAtribuidas: 8,
      demandasEmAndamento: 4,
      demandasResolvidas: 4,
      dataUltimaAtualizacao: "20/01/2025",
      progresso: 80,
    }
  ];

  toggleProjetoInfo(projetoInfoDiv: HTMLElement) {
    if (projetoInfoDiv.classList.contains('max-w-full')) {
      projetoInfoDiv.classList.remove('max-w-full', 'p-3', 'border', 'border-gray-200');
      projetoInfoDiv.classList.add('max-w-0');
    } else {
      projetoInfoDiv.classList.remove('max-w-0');
      projetoInfoDiv.classList.add('max-w-full', 'p-3', 'border', 'border-gray-200');
    }
  }
}