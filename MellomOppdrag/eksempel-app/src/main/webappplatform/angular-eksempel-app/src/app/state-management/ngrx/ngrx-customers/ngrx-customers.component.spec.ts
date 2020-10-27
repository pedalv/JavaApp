import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgrxCustomersComponent } from './ngrx-customers.component';

describe('NgrxCustomersComponent', () => {
  let component: NgrxCustomersComponent;
  let fixture: ComponentFixture<NgrxCustomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgrxCustomersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgrxCustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
