import { TestBed } from '@angular/core/testing';

import { ClonerService } from './cloner.service';
import { DataService } from './data.service';

describe('DataService', () => {
  let service: DataService;

  beforeEach(() => {
    TestBed.configureTestingModule({
     });
    service = TestBed.inject(DataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});









/*
// Http testing module and mocking controller
import { HttpClientTestingModule } from '@angular/common/http/testing';

// Other imports
import { TestBed, async, inject } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';

import { DataService } from './data.service';
import { UtilitiesService } from './utilities.service';

describe('DataService', () => {
  let httpClient: HttpClient;
  let service: DataService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [
        UtilitiesService,
        { provide: 'Window', useValue: 'localhost' },
        { provide: 'port', useValue: '4200' }
      ]
    });
    // Inject the http service and test controller for each test
    httpClient = TestBed.get(HttpClient);
    service = TestBed.inject(DataService);
  });

  //Chrome 86.0.4240.75 (Windows 10) DataService should be created DATASERVICES FAILED
  it('should be created DATASERVICES', () => {
    expect(service).toBeTruthy();
  });

});
*/
