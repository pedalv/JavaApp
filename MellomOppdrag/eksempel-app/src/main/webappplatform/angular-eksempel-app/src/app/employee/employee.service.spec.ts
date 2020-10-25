// Http testing module and mocking controller
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

// Other imports
import { TestBed, async, inject } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';

import { EmployeeService } from './employee.service';
import { Employee } from '../domain/employee';

describe('HttpClient testing', () => {
  let httpClient: HttpClient;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [ EmployeeService]
    });

    // Inject the http service and test controller for each test
    httpClient = TestBed.get(HttpClient);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  it('works', () => {
  });
});


describe('EmployeeService', () => {
  let service: EmployeeService;
  //let httpClient: HttpTestingController;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers : [ EmployeeService ]
    });
    service = TestBed.inject(EmployeeService);
    httpMock = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it(`should fetch all employees as an Observable`, async( inject(
    [HttpTestingController, EmployeeService],
    (httpClient: HttpTestingController, empservice: EmployeeService) => {

        const employeesStub = [
          {
            "id": 10,
            "firstName":"P",
            "lastName":"M",
            "role":"Seniorutvikler"
          },
          {
            "id": 11,
            "firstName":"L",
            "lastName":"A",
            "role":"Leder"
          }
        ];

        empservice.allEmployees()
          .subscribe((employees : Employee[]) => {
            expect(employees.length).toBe(2);
          });

          let req = httpMock.expectOne('/api/employee/all');
          expect(req.request.method).toBe("GET");

          req.flush(employeesStub);
          httpMock.verify();

        }
    )));

});
