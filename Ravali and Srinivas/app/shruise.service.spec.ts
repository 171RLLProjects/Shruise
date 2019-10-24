import { TestBed, inject } from '@angular/core/testing';

import { ShruiseService } from './shruise.service';

describe('ShruiseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShruiseService]
    });
  });

  it('should be created', inject([ShruiseService], (service: ShruiseService) => {
    expect(service).toBeTruthy();
  }));
});
