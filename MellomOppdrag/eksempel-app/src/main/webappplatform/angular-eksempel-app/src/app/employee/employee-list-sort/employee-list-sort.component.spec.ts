// Http testing module and mocking controller
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NgpSortModule } from "ngp-sort-pipe";

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeService } from '../employee.service';
import { EmployeeListSortComponent } from './employee-list-sort.component';

describe('EmployeeListSortComponent', () => {
  let EmployeeServiceStub: Partial<EmployeeService>;
  let component: EmployeeListSortComponent;
  let fixture: ComponentFixture<EmployeeListSortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListSortComponent ],
      imports: [ HttpClientTestingModule, NgpSortModule ],
      providers: [ {provide: EmployeeService, useValue: EmployeeService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListSortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
