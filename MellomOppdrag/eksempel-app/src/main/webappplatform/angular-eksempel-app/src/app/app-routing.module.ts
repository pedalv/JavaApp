import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PartnerComponent } from './partner/partner.component';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';
import { HomeComponent } from './home/home.component';
import { KafkaComponent } from './kafka/kafka.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "kafka", component: KafkaComponent },
  { path: "partner", component: PartnerComponent },
  { path: "customer", component: CustomerComponent },
  { path: "employee", component: EmployeeComponent },
  { path: "users", loadChildren: () => import('./users/users-routing.module').then(u => u.UsersModule) }
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
