import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListSortComponent } from './employee-list-sort.component';

describe('EmployeeListSortComponent', () => {
  let component: EmployeeListSortComponent;
  let fixture: ComponentFixture<EmployeeListSortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListSortComponent ]
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
