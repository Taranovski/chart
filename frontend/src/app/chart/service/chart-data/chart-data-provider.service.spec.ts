import { TestBed, inject } from '@angular/core/testing';

import { ChartDataProviderService } from './chart-data-provider.service';

describe('ChartDataProviderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChartDataProviderService]
    });
  });

  it('should be created', inject([ChartDataProviderService], (service: ChartDataProviderService) => {
    expect(service).toBeTruthy();
  }));
});
