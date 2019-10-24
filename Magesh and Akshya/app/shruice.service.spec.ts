import { TestBed, inject } from '@angular/core/testing';

import { ShruiceService } from './shruice.service';

describe('ShruiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShruiceService]
    });
  });

  it('should be created', inject([ShruiceService], (service: ShruiceService) => {
    expect(service).toBeTruthy();
  }));
});
