import { Component, OnInit } from '@angular/core';

//import * as CustomerActions  from '../state/customer.actions';
import { CustomerPageActions } from './state/actions'

import { ICustomer } from '../../shared/interfaces';
import { DataService } from '../../core/services/data.service';
import { ClonerService } from '../../core/services/cloner.service';
import { State, getShowCustomerFlag,
        getCustomerSelected, getCustomers,
         getError } from './state';
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
    // Use 1: view - getShowCustomerFlag
    this.store.select(getShowCustomerFlag).subscribe(
      showCustomerFlag => this.displayCustomers = showCustomerFlag
    ); //Store

    //show list of customers Action(here) and Select(error: here and list: custumer-list)
    // Use 4: loadCustomers
    this.store.dispatch(CustomerPageActions.loadCustomers()); //Store
    //Use 2: view - getError
    this.errorMessage$ = this.store.select(getError); //Store


    //add customer
    /*DELETEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    // Use 3: view - getInitializeSelectedCustomer
   // this.store.select(getInitializeSelectedCustomer).subscribe(
     // customerSelectedId => this.customer = customerSelectedId
    //); //Store
*/
    //Use 4: view -  getCustomerSelected
    this.store.select(getCustomerSelected).subscribe(
      customerSelectedId => this.customer = customerSelectedId
    ); //Store

  }

  //check element
  checkChanged(): void {
    //Use 3: showCustomerFlag
    this.store.dispatch(
      CustomerPageActions.toggleShowCustomerFlag()
      //{ type: '[Customers] IS Show Customers'}
    );
  }

  addCustomerClone() {
    //Use 2: initializeSelectedCustomer
    this.store.dispatch(CustomerPageActions.initializeSelectedCustomer()); //Store
  }

}


/*
    customerReducer
    //Store: customers Action: toggleShowCustomerFlag
    //Store: customers Action: customersList
    //Store: customer Action: customerSelected === currentCustomerId
    customers: {
       showCustomerFlag: true,
       customerSelected: null,
       currentCustomerId: -1,
       customersList: []
     }
*/

/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
