// Http testing module and mocking controller
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NgpSortModule } from "ngp-sort-pipe";

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeService } from '../employee.service';
import { EmployeeDetailsComponent } from './employee-details.component';

describe('EmployeeShowComponent', () => {
  //let EmployeeServiceStub: Partial<EmployeeService>;
  let component: EmployeeDetailsComponent;
  let fixture: ComponentFixture<EmployeeDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeDetailsComponent ],
      imports: [ HttpClientTestingModule, NgpSortModule ],
      providers: [ {provide: EmployeeService, useValue: EmployeeService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
