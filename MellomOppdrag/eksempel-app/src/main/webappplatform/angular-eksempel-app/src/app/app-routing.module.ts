import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PartnerComponent } from './partner/partner.component';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';
import { HomeComponent } from './home/home.component';
import { KafkaComponent } from './kafka/kafka.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "kafka", component: KafkaComponent },
  { path: "partner", component: PartnerComponent }, //boostrap-form
  { path: "customer", component: CustomerComponent }, //jumbotron
  { path: "employee", component: EmployeeComponent }, //boostrao-table
  { path: "login", component: LoginComponent },
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
