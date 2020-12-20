// Http testing module and mocking controller
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

// Other imports
import { TestBed, async, inject } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';

import { EmployeeService } from './employee.service';
import { Employee } from '../domain/employee';
import {Observable} from "rxjs";

describe('HttpClient testing', () => {
  //sytem under test
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
    // arrange

    // act

    // assert
    expect(httpClient).toBeTruthy();
    expect(httpTestingController).toBeTruthy();
  });
});


describe('EmployeeService', () => {
  //sytem under test
  let service: EmployeeService;
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
    // arrange

    // act

    // assert
    expect(service).toBeTruthy();
  });

  it(`should fetch all employees as an Observable`, async( inject(

    [HttpTestingController, EmployeeService],
    (httpClient: HttpTestingController, empservice: EmployeeService) => {

      // arrange
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


      // act
      empservice.allEmployees()
        .subscribe((employees : Employee[]) => {
          expect(employees.length).toBe(2);
        });

      // assert
      let req = httpMock.expectOne('/api/employee/all');
      expect(req.request.method).toBe("GET");

      req.flush(employeesStub);
      httpMock.verify();

    }
    )));


  it(`should create employee`, async( inject(
    [HttpTestingController, EmployeeService],
    (httpClient: HttpTestingController, empservice: EmployeeService) => {

      // arrange
      const employeeCreated= {
          "id": 0,
          "firstName":"P",
          "lastName":"M",
          "role":"Seniorutvikler"
        };

      // act
      let result: Observable<Object> = empservice.createEmployee(employeeCreated);

      // assert
      result.subscribe((employees : Employee) => {
        expect(employees.id).toBe(0);
        expect(employees.firstName).toBe('P');
        expect(employees.lastName).toBe('M');
        expect(employees.role).toBe('Seniorutvikler');
      });

      let req = httpMock.expectOne('/api/employee/add');
      expect(req.request.method).toBe("POST");
      req.flush(employeeCreated);
      httpMock.verify();
    }
  )));


  it(`should replace employee`, async( inject(
    [HttpTestingController, EmployeeService],
    (httpClient: HttpTestingController, empservice: EmployeeService) => {

      // arrange
      const employeereplaced= {
        "id": 10,
        "firstName":"P",
        "lastName":"M",
        "role":"Seniorutvikler"
      };

      // act
      let result: Observable<Object> = empservice.replaceEmployee(employeereplaced);

      // assert
      result.subscribe((employees : Employee) => {
        expect(employees.id).toBe(10);
        expect(employees.firstName).toBe('P');
        expect(employees.lastName).toBe('M');
        expect(employees.role).toBe('Seniorutvikler');
      });

      let req = httpMock.expectOne('/api/employee/10');
      expect(req.request.method).toBe("PUT"); //Update — PUT/PATCH === version + minor updates/minor updates
      req.flush(employeereplaced);
      httpMock.verify();
    }
  )));


  it(`should single employee`, async( inject(
    [HttpTestingController, EmployeeService],
    (httpClient: HttpTestingController, empservice: EmployeeService) => {

      // arrange
      const employeeSingle= {
        "id": 10,
        "firstName":"P",
        "lastName":"M",
        "role":"Seniorutvikler"
      };

      // act
      let result: Observable<Object> = empservice.singleEmployee(employeeSingle.id);

      // assert
      result.subscribe((employees : Employee) => {
        expect(employees.id).toBe(10);
        expect(employees.firstName).toBe('P');
        expect(employees.lastName).toBe('M');
        expect(employees.role).toBe('Seniorutvikler');
      });

      let req = httpMock.expectOne('/api/employee/10');
      expect(req.request.method).toBe("GET"); //Update — PUT/PATCH === version + minor updates/minor updates
      req.flush(employeeSingle);
      httpMock.verify();
    }
  )));

  it(`should delete employee`, async( inject(
    [HttpTestingController, EmployeeService],
    (httpClient: HttpTestingController, empservice: EmployeeService) => {

      // arrange
      const employeeDelete= {
        "id": 10,
        "firstName":"P",
        "lastName":"M",
        "role":"Seniorutvikler"
      };

      // act
      let result: Observable<Object> = empservice.deleteEmployee(employeeDelete.id);

      // assert
      result.subscribe((employees : Employee) => {
        expect(employees.id).toBe(10);
        expect(employees.firstName).toBe('P');
        expect(employees.lastName).toBe('M');
        expect(employees.role).toBe('Seniorutvikler');
      });

      let req = httpMock.expectOne('/api/employee/10');
      expect(req.request.method).toBe("DELETE"); //Update — PUT/PATCH === version + minor updates/minor updates
      req.flush(employeeDelete);
      httpMock.verify();
    }
  )));

});
