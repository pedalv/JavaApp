// Http testing module and mocking controller
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeService } from '../services/employee.service';
import { EmployeeComponent } from './employee.component';

describe('EmployeeComponent', () => {
  let EmployeeServiceStub: Partial<EmployeeService>;
  let component: EmployeeComponent;
  let fixture: ComponentFixture<EmployeeComponent>;

  beforeEach(async () => {

    await TestBed.configureTestingModule({
      declarations: [ EmployeeComponent ],
      imports: [ HttpClientTestingModule ],
      providers: [ {provide: EmployeeService, useValue: EmployeeService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('showError is false', () => {
      expect(component.showError).toBeFalsy(false);
    });


});
