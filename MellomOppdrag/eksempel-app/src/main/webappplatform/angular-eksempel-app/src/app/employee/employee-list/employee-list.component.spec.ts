// Http testing module and mocking controller
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NgpSortModule } from "ngp-sort-pipe";

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeService } from '../employee.service';
import { EmployeeListComponent } from './employee-list.component';

describe('EmployeeListComponent', () => {
  let EmployeeServiceStub: Partial<EmployeeService>;
  let component: EmployeeListComponent;
  let fixture: ComponentFixture<EmployeeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListComponent ],
      imports: [ HttpClientTestingModule, NgpSortModule ],
      providers: [ {provide: EmployeeService, useValue: EmployeeService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
