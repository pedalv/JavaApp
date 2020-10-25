import { TestBed } from '@angular/core/testing';

import { ClonerService } from './cloner.service';

describe('CloneService', () => {
  let service: ClonerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClonerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
