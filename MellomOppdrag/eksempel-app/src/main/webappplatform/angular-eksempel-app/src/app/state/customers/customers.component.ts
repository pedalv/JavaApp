import { Component, OnInit } from '@angular/core';

import { ICustomer } from '../../shared/interfaces';
import { DataService } from '../../core/services/data.service';
import { ClonerService } from '../../core/services/cloner.service';

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

  constructor(private store: Store<any>,
              private dataService: DataService,
              private clonerService: ClonerService) { }

  ngOnInit(): void {
    this.sub = this.dataService.getCustomers()
            .subscribe((custs: ICustomer[]) =>{
              this.customers = custs;
              console.log("getCustomers");
              console.log(this.customers);
            });

        // TODO: Unsubscribe
        this.store.select('customers').subscribe(
          customers => {

            if (customers) {
              this.displayCustomers = customers.isShowCustomers;
              //this.customers = customers.customers;
              //this.customer = customers.customer;
            }
          });

  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  checkChanged(): void {
    this.store.dispatch(
      { type: '[Customers] IS Show Customers'}
    );
  }

  onSelect(cust: ICustomer) {
    console.log("changed");
    console.log(cust);
    //this.customer = customer;
    this.customer = this.clonerService.deepClone<ICustomer>(cust); //Clone ref
  }

  addCustomerClone() {
      this.dataService.addCustomerClone()
          .subscribe((custs: ICustomer[]) => this.customers = custs);
  }

}
