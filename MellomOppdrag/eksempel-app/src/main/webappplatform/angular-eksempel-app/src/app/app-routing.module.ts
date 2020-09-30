import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PartnerComponent } from './partner/partner.component';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  { path: "partner", component: PartnerComponent },
  { path: "customer", component: CustomerComponent },
  { path: "employee", component: EmployeeComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
