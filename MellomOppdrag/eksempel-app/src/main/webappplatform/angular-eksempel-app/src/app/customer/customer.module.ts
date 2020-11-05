import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { CustomerRoutingModule } from './customer-routing.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

@NgModule({
  imports:      [ CommonModule, CustomerRoutingModule ],
  declarations: [ CustomerRoutingModule.components, CustomersListComponent, CustomerDetailsComponent ]
})
export class CustomerModule { }
