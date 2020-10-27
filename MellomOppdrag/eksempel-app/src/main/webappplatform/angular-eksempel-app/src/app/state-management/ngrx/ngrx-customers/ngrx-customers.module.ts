import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
//import { CustomersListComponent } from './customers-list/customers-list.component';
//import { FilterTextboxComponent } from './customers-list/filter-textbox.component';
import { NgrxCustomersComponent } from './ngrx-customers.component';
import { NgrxCustomersRoutingModule } from './ngrx-customers-routing.module';
//import { CustomersEditComponent } from './customers-edit/customers-edit.component';

@NgModule({
    imports: [ CommonModule, SharedModule, NgrxCustomersRoutingModule ],
    declarations: [ /*CustomersListComponent, FilterTextboxComponent,CustomersEditComponent */ NgrxCustomersComponent]
})

export class NgrxCustomersModule { }

--


export class CustomersModule { }
