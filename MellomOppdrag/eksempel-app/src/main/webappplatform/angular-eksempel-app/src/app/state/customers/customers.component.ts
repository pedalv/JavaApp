import { Component, OnInit } from '@angular/core';

import * as CustomerActions  from './state/customer.actions';
import { ICustomer } from '../../shared/interfaces';
import { DataService } from '../../core/services/data.service';
import { ClonerService } from '../../core/services/cloner.service';
import { State, getIsShowCustomers,
        getCurrentCustomer, getCustomerList,
        getCustomerSelected, getInitializeCurrentCustomer,
         getError } from './state/customer.reducer';
import { Subscription, Observable } from 'rxjs';

/* NgRx */
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.less']
})
export class CustomersComponent implements OnInit {

  customer: ICustomer;

  displayCustomers: boolean;
  customers$: Observable<ICustomer[]>;
  customer$: Observable<ICustomer | null>;
  errorMessage$: Observable<string | null>;

  constructor(private store: Store<State>,
              private dataService: DataService,
              private clonerService: ClonerService) { }

  ngOnInit(): void {

    //check element
    this.store.select(getIsShowCustomers).subscribe(
      isShowCustomers => this.displayCustomers = isShowCustomers
    ); //Store

    //show list of customers Action(here) and Select(error: here and list: custumer-list)
    this.store.dispatch(CustomerActions.loadCustomers()); //Store
    this.errorMessage$ = this.store.select(getError); //Store


    //add customer todo
    this.store.select(getInitializeCurrentCustomer).subscribe(
      currentCustomer => this.customer = currentCustomer
    ); //Store

    this.store.select(getCurrentCustomer).subscribe(
      currentCustomerId => this.customer = currentCustomerId
    ); //Store

  }

  //check element
  checkChanged(): void {
    this.store.dispatch(
      CustomerActions.isShowCustomers()
      //{ type: '[Customers] IS Show Customers'}
    );
  }

  //add customer todo
  addCustomerClone() {
    //TODO update
    //this.dataService.addCustomerClone().subscribe((custs: ICustomer[]) => this.customers = custs);

    this.store.dispatch(CustomerActions.initializeCurrentCustomer()); //Store
  }

}


/*
    customerReducer
    //Store: customers Action: isShowCustomers
    //Store: customers Action: customersList
    //Store: customer Action: customerSelected === currentCustomerId
    customers: {
       isShowCustomers: true,
       customerSelected: null,
       currentCustomerId: -1,
       customersList: []
     }
*/

/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
