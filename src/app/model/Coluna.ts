import { Tarefa } from "./Tarefa";

export class Coluna {
    constructor(public nome: string, public id: string, public tarefas: Tarefa[]) {}
  }
  