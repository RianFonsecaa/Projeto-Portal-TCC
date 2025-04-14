export interface TimelineDay {
  date: Date;
  isWeekend: boolean;
}

export interface MonthDisplay {
  month: string;
  year: number;
  days: number;
  startDate: Date;
}
