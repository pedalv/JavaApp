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
});
