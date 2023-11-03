import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

import { SharedModule } from '../../shared/shared.module';

/* NgRx */
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { customerReducer } from './state/customer.reducer';
import { CustomerEffects } from './state/customer.effects';


@NgModule({
  imports:      [
    CommonModule,
    SharedModule,
    CustomersRoutingModule,
    StoreModule.forFeature('customers', customerReducer),
    /*
        customerReducer
        //Store: customers Action: toggleShowCustomers
        //Store: customers Action: customersList
        //Store: customer Action: customerSelected === currentCustomerId
        customers: {
           toggleShowCustomers: true,
           customerSelected: null,
           currentCustomerId: -1,
           customersList: []
         }
    */
    EffectsModule.forFeature([CustomerEffects])
  ],
  declarations: [ CustomersRoutingModule.components, CustomersListComponent, CustomerDetailsComponent ]
})
export class CustomersModule { }
