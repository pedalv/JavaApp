import { Component, OnInit, Input, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

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

    this.customer$ = this.store.select(getCustomerSelected)
      .pipe(
        tap(customerSelected => this.customer = customerSelected)
      );
  }

  edit() : void {
    console.log("Change");
    console.log(this.customer);
    this.isdetails = !this.isdetails;
  }

  save(customer:ICustomer) : void {
    console.log("Change customer");
    console.log(this.customer);
    this.isdetails = !this.isdetails;
    //send output to save
    //Update(add) to list
  }

  cancel(): void {
    console.log("Cancel");
    this.customer = null;
    //send output to reset selected customer
  }

}

/*
Cancel Action

Save Action
Save Success
Save Feil

Add Action
*/


/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
