import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

/* NgRx */
import { StoreModule } from '@ngrx/store';
import { customersReducer } from './customers.reducer';


@NgModule({
  imports:      [
    CommonModule,
    CustomersRoutingModule,
    StoreModule.forFeature('customers', customersReducer)
    /*
        customerReducer
        //Store: customers Action: isShowCustomers
        //Store: customers Action: showCustomersList
        //Store: customer Action: showSelectedCustomer
        customers: {
           isShowCustomers: true,
           customerSelected: null,
           currentCustomerId: -1,
           customersList: []
         }
    */
  ],
  declarations: [ CustomersRoutingModule.components, CustomersListComponent, CustomerDetailsComponent ]
})
export class CustomersModule { }
