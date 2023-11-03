import { Component, OnInit } from '@angular/core';

import { Customer } from '../../../core/model/customer';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { EntityState, CustomerSelectors } from '../store';
import * as CustomerAction from '../store/actions';


@Component({
  selector: 'app-ngrx-customers',
  templateUrl: './ngrx-customers.component.html',
  styleUrls: ['./ngrx-customers.component.less']
})
export class NgrxCustomersComponent implements OnInit {

  title = 'Customers';
  customers$: Observable<Customer[]>;
  loading$: Observable<boolean>;


  constructor(
      private store: Store<EntityState>,
      private customerSelectors: CustomerSelectors) {

      this.customers$ = this.customerSelectors.customers$;
      this.loading$ = this.customerSelectors.loading$;

  }

  ngOnInit(): void {
  }

  getCustomers() {
    //1 - 10
    this.store.dispatch(new CustomerAction.GetCustomers()); //1

    /*
    1 component: GetCustomers()
    2 actions
    3 effects
    4 server
    5 effects
    6 actions
    7 reducers
    8 state (store)
    9 selectors$
    10 component
    */


  }

}
