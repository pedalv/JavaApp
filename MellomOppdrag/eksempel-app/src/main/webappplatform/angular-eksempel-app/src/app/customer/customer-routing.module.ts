import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CustomerComponent } from './customer.component';

const routes: Routes = [
  { path: "", component: CustomerComponent }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ],
  declarations: [ ]
})
export class CustomerRoutingModule {
  static components = [ CustomerComponent ];
}
