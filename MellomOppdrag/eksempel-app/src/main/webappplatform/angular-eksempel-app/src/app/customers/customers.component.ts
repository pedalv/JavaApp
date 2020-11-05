import { Component, OnInit, OnDestroy } from '@angular/core';

import { ICustomer } from '../shared/interfaces';
import { DataService } from '../core/services/data.service';
import { SubSink } from 'subsink';
import { ClonerService } from '../core/services/cloner.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.less']
})
export class CustomersComponent implements OnInit, OnDestroy {

  customers: ICustomer[] = [];
  customer: ICustomer;
  private subs = new SubSink();

  constructor(private dataService: DataService, private clonerService: ClonerService) { }

  ngOnInit() {
    this.subs.sink = this.dataService.getCustomers()
        .subscribe((custs: ICustomer[]) =>{
          this.customers = custs;
          console.log("getCustomers");
          console.log(this.customers);
        });
  }

    onSelect(cust: ICustomer) {
      console.log("changed");
      console.log(cust);
      //this.customer = customer;
      this.customer = this.clonerService.deepClone<ICustomer>(cust); //Clone ref
    }

    addCustomerPush() {
      this.dataService.addCustomer()
          .subscribe((custs: ICustomer[]) => this.customers = custs);
    }

    addCustomerClone() {
      this.dataService.addCustomerClone()
          .subscribe((custs: ICustomer[]) => this.customers = custs);
    }

    //Event-Bus
    ngOnDestroy() {
      this.subs.unsubscribe();
    }

}
