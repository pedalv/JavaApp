import { Component, OnInit } from '@angular/core';

import { ICustomer } from '../../shared/interfaces';
import { DataService } from '../../core/services/data.service';
import { ClonerService } from '../../core/services/cloner.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.less']
})
export class CustomersComponent implements OnInit {

  customers: ICustomer[] = [];
  customer: ICustomer;

  constructor(private dataService: DataService, private clonerService: ClonerService) { }

  ngOnInit(): void {
    this.dataService.getCustomers()
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

  addCustomerClone() {
      this.dataService.addCustomerClone()
          .subscribe((custs: ICustomer[]) => this.customers = custs);
  }

}
