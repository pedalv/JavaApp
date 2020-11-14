import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersComponent } from './customers.component';

/* NgRx */
//import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { StoreModule } from '@ngrx/store';
import { customerReducer } from './state/customer.reducer';
//TODO https://ngrx.io/guide/store/testing

describe('CustomersComponent', () => {
  let component: CustomersComponent;
  let fixture: ComponentFixture<CustomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersComponent ],
      imports: [StoreModule.forRoot({ customers: customerReducer })],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
