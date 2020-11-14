import { Component, OnInit, Input, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

import { Observable } from 'rxjs';
import { State, getCustomerSelected } from '../state/customer.reducer';

/* NgRx */
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerDetailsComponent implements OnInit {

  //@Input() customer: ICustomer; //Send
  customer$: Observable<ICustomer>;

  constructor(private store: Store<State>) {}

  ngOnInit(): void {
    console.log("customer details")
    //??
    this.customer$ = this.store.select(getCustomerSelected); //Store
  }

}


/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
