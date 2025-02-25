import { Component, Input } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule, NgClass } from '@angular/common';
import { Demanda } from '../../model/AlunoDemanda';



@Component({
  selector: 'app-tarefas-conteudo',
  standalone :true,
  imports :[CommonModule, NgClass],
  templateUrl: './tarefas-conteudo.component.html'
})
export class TarefasConteudoComponent {
  @Input() titulo: string = ''; 
  @Input() descricao: string = '';
  @Input() status: string ='';
  @Input() imgSource: string = ''; 
  @Input() prioridade: string ='';
  @Input() dataCriacao : Date = new Date()

  @Input() tarefa: Demanda = {
    id: 0,
    nomeTarefa: '',
    descricao: '',
    prazo: new Date,
    prioridade: 'BAIXA',
    status: 'BACKLOG'
  };

  constructor(){
    this.tarefa;
  }

  get prazoColor(): string {
    switch ((this.tarefa.status ?? '').toLowerCase()) { 
      case 'concluida':
        return 'text-green-600';
      case 'andamento': 
        return 'text-yellow-600';
      case 'pendente':
        return 'text-red-300';
      default:
        return 'text-gray-600';
    }
  }
}
