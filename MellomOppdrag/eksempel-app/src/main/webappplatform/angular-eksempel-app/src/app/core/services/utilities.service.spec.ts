import { TestBed } from '@angular/core/testing';

import { UtilitiesService } from './utilities.service';

describe('UtilitiesService', () => {
  let service: UtilitiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: 'Window', useValue: 'localhost' }
      ]
   });
    service = TestBed.inject(UtilitiesService);
  });

  it('should be created UTILITIESSERVICE', () => {
    expect(service).toBeTruthy();
  });
});
