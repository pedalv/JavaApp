import { Component, OnInit } from '@angular/core';

import * as CustomerActions  from './state/customer.actions';
import { ICustomer } from '../../shared/interfaces';
import { DataService } from '../../core/services/data.service';
import { ClonerService } from '../../core/services/cloner.service';
import { State, getIsShowCustomers,
        getCurrentCustomer, getCustomersList,
        getCustomerSelected, getInitializeCurrentCustomer } from './state/customer.reducer';
import { Subscription } from 'rxjs';

/* NgRx */
import { Store } from '@ngrx/store';


@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.less']
})
export class CustomersComponent implements OnInit {

  customers: ICustomer[] = [];
  customer: ICustomer;

  displayCustomers: boolean;
  sub: Subscription;

  constructor(private store: Store<State>,
              private dataService: DataService,
              private clonerService: ClonerService) { }

  ngOnInit(): void {

    this.sub = this.dataService.getCustomers()
            .subscribe((custs: ICustomer[]) =>{
              this.customers = custs;
              console.log("getCustomers");
              console.log(this.customers);
            });

        this.store.select(getCustomerSelected).subscribe(
          customerSelected => this.customer = customerSelected
        ); //Store

        this.store.select(getInitializeCurrentCustomer).subscribe(
          //currentCustomer => this.customer = currentCustomer
        ); //Store


        this.store.select(getIsShowCustomers).subscribe(
          isShowCustomers => this.displayCustomers = isShowCustomers
        );

        this.store.select(getCurrentCustomer).subscribe(
          currentCustomerId => this.customer = currentCustomerId
        );
/*
        this.store.select('customers').subscribe(
          customers => {
             this.displayCustomers = customers.isShowCustomers;
             //this.customers = customers.customers;
             //this.customer = customers.customer;
        });
*/
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  checkChanged(): void {
    this.store.dispatch(
      CustomerActions.isShowCustomers()
      //{ type: '[Customers] IS Show Customers'}
    );
  }

  onSelect(customer: ICustomer) {
    console.log("changed");
    console.log(customer);
    //this.customer = customer;
    //this.customer = this.clonerService.deepClone<ICustomer>(customer); //Clone ref

    this.store.dispatch(CustomerActions.setCustomerSelected( { customer } )); //Store
  }

  addCustomerClone() {
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
