import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
//import { CommonModule } from '@angular/common';
//import { FormsModule } from '@angular/forms';
import { PartnerComponent } from './partner/partner.component';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  { path: "partner", component: PartnerComponent }, //boostrap-form
  { path: "customer", component: CustomerComponent }, //jumbotron
  { path: "employee", component: EmployeeComponent } //boostrao-table
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
