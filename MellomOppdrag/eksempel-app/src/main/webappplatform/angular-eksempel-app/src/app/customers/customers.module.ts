import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

@NgModule({
  imports:      [ CommonModule, CustomersRoutingModule ],
  declarations: [ CustomersRoutingModule.components, CustomersListComponent, CustomerDetailsComponent ]
})
export class CustomersModule { }
