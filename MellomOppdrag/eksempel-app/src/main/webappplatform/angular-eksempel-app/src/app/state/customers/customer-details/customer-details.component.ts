import { Component, OnInit, Input, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

import * as CustomerActions  from '../state/customer.actions';

import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
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

  customer$: Observable<ICustomer>;
  customer: ICustomer;

  isdetails: boolean;

  constructor(private store: Store<State>) {}

  ngOnInit(): void {
    console.log("customer details")
    this.isdetails = true;

    // Use 5: getCustomerSelected
    this.customer$ = this.store.select(getCustomerSelected)
      .pipe(
        tap(customerSelected => this.customer = customerSelected)
      );


    //USE 7 : clearCustomer
    //this.store.dispatch(CustomerActions.clearCustomer()); //Store
  }

  edit() : void {
    console.log("Change");
    console.log(this.customer);
    this.isdetails = !this.isdetails;
  }

  save(customer:ICustomer) : void {
    console.log("Change Save customer");
    console.log(this.customer);
    this.isdetails = !this.isdetails;

    if(customer.id === 0) {
      //Create
      this.store.dispatch(CustomerActions.createCustomer({ customer }));
    } else {
      //Update
      this.store.dispatch(CustomerActions.updateCustomer({ customer }));
    }
  }

  cancel(): void {
    console.log("Cancel");
    this.isdetails = true;
    this.customer.id = 0;
    this.customer.name = 'New';
    this.customer.project = '';
  }

}

/*

Save Action
Save Success
Save Feil

*/


/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/