// Http testing module and mocking controller
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NgpSortModule } from "ngp-sort-pipe";

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeService } from '../employee.service';
import { EmployeeCreateComponent } from './employee-create.component';

describe('EmployeeCreateComponent', () => {
  let EmployeeServiceStub: Partial<EmployeeService>;
  let component: EmployeeCreateComponent;
  let fixture: ComponentFixture<EmployeeCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeCreateComponent ],
      imports: [ HttpClientTestingModule, NgpSortModule ],
      providers: [ {provide: EmployeeService, useValue: EmployeeService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
