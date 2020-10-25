import { Component, OnInit, OnDestroy } from '@angular/core';

import { ICustomer2 } from '../shared/interfaces';
import { DataService } from '../core/services/data.service';
import { SubSink } from 'subsink';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.less']
})
export class CustomerComponent implements OnInit, OnDestroy {

  customers: ICustomer2[] = [];
  customer: ICustomer2;
  private subs = new SubSink();

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.subs.sink = this.dataService.getCustomers()
        .subscribe((custs: ICustomer2[]) =>{
          this.customers = custs;
          console.log(this.customers);
        });
  }

    selected(cust: ICustomer2) {
      this.customer = cust;
    }

    addCustomerPush() {
      this.dataService.addCustomer()
          .subscribe((custs: ICustomer2[]) => this.customers = custs);
    }

    addCustomerClone() {
      this.dataService.addCustomerClone()
          .subscribe((custs: ICustomer2[]) => this.customers = custs);
    }

    ngOnDestroy() {
      this.subs.unsubscribe();
    }

}
