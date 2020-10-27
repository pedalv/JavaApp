import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgrxDataCustomersComponent } from './ngrx-data-customers.component';

describe('NgrxDataCustomersComponent', () => {
  let component: NgrxDataCustomersComponent;
  let fixture: ComponentFixture<NgrxDataCustomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgrxDataCustomersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgrxDataCustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
