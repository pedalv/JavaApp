import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

/* NgRx */
import { StoreModule } from '@ngrx/store';
import { customerReducer } from './state/customer.reducer';


@NgModule({
  imports:      [
    CommonModule,
    CustomersRoutingModule,
    StoreModule.forFeature('customers', customerReducer)
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
  ],
  declarations: [ CustomersRoutingModule.components, CustomersListComponent, CustomerDetailsComponent ]
})
export class CustomersModule { }
