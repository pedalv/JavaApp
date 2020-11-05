import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { StateManagementComponent } from './state-management.component';
import { CustomersNgrxComponent } from './customers-ngrx/customers-ngrx.component';
import { NgrxCustomersComponent } from './ngrx/ngrx-customers/ngrx-customers.component';
import { NgrxDataCustomersComponent } from './ngrx-data/ngrx-data-customers/ngrx-data-customers.component';
import { ObservableStoreCustomersComponent } from './observable-store/observable-store-customers/observable-store-customers.component';

const routes: Routes = [
  {
    path: "",
    component: StateManagementComponent,
    children: [
      { path: 'customers', component: CustomersNgrxComponent },
      { path: 'ngrx', component: NgrxCustomersComponent },
      { path: 'ngrx-data', component: NgrxDataCustomersComponent },
      { path: 'observable-store', component: ObservableStoreCustomersComponent },
    ]
  }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ],
  declarations: [  ]
})
export class StateManagementRoutingModule {
  static components = [ StateManagementComponent, NgrxCustomersComponent,  NgrxDataCustomersComponent, ObservableStoreCustomersComponent];
}
