import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

import { Observable } from 'rxjs';
import { State, getCustomers } from '../state/customer.reducer';
import * as CustomerActions  from '../state/customer.actions';

/* NgRx */
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomersListComponent implements OnInit {

  customers$: Observable<ICustomer[]>; //Subscribe

  constructor(private store: Store<State>) {}

  ngOnInit(): void {
    // Use 6: view - getCustomers
    this.customers$ = this.store.select(getCustomers); //Store
  }

  selected(customer: ICustomer) : void {
    console.log("customer selected");
    console.log(customer);
    //USE 1 : setSelectedCustomer
    this.store.dispatch(CustomerActions.setSelectedCustomer( { customerSelectedId: customer.id } )); //Store
  }

}

/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
