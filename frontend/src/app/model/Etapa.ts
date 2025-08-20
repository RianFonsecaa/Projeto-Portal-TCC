import { Tarefa } from "./Tarefa";

export interface Etapa {
  id: number;
  name: string;
  start: Date;
  end: Date;
  duration: number;
  subtasks?: Tarefa[];
  expanded?: boolean;
}
