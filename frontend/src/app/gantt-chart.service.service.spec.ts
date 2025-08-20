import { TestBed } from '@angular/core/testing';

import { GanttChartServiceService } from './pages/etapas/gantt-chart.service.service';

describe('GanttChartServiceService', () => {
  let service: GanttChartServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GanttChartServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
