import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObservableStoreCustomersComponent } from './observable-store-customers.component';

describe('ObservableStoreCustomersComponent', () => {
  let component: ObservableStoreCustomersComponent;
  let fixture: ComponentFixture<ObservableStoreCustomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObservableStoreCustomersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObservableStoreCustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
