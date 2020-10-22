// Http testing module and mocking controller
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NgpSortModule } from "ngp-sort-pipe";

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeService } from '../employee.service';
import { EmployeeShowComponent } from './employee-show.component';

describe('EmployeeShowComponent', () => {
  let EmployeeServiceStub: Partial<EmployeeService>;
  let component: EmployeeShowComponent;
  let fixture: ComponentFixture<EmployeeShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeShowComponent ],
      imports: [ HttpClientTestingModule, NgpSortModule ],
      providers: [ {provide: EmployeeService, useValue: EmployeeService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
