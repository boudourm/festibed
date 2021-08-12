import { TestBed } from '@angular/core/testing';

import { FestivalServiceService } from './festival-service.service';

describe('FestivalServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FestivalServiceService = TestBed.get(FestivalServiceService);
    expect(service).toBeTruthy();
  });
});
