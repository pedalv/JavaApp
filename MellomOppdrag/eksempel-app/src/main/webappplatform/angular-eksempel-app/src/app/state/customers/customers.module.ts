import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

/* NgRx */
import { StoreModule } from '@ngrx/store';
import { customerReducer } from './customer-reducer';


@NgModule({
  imports:      [
    CommonModule,
    CustomersRoutingModule,
    StoreModule.forFeature('customers', customerReducer)
    /*
        //customerReducer
        //Store: customers Action: showCustomersList
        //Store: customer Action: showSelectedCustomer
        customers: {
          customerSelected | customer: [],
          customers: {}
        }
        */
  ],
  declarations: [ CustomersRoutingModule.components, CustomersListComponent, CustomerDetailsComponent ]
})
export class CustomersModule { }
