import { NgModule } from '@angular/core';
//import { Routes, RouterModule } from '@angular/router';
import { RouterModule, Routes, PreloadAllModules, NoPreloading } from '@angular/router';

import { HomeComponent } from './home/home.component';

const app_routes: Routes = [
  { path: "", pathMatch: 'full', component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "kafka", loadChildren: () => import('./kafka/kafka.module').then(m => m.KafkaModule) },
  { path: "customer", loadChildren: () => import('./customer/customer.module').then(m => m.CustomerModule) },
  { path: "partner", loadChildren: () => import('./partner/partner.module').then(m => m.PartnerModule) },
  { path: "employee", loadChildren: () => import('./employee/employee.module').then(m => m.EmployeeModule) },
  { path: "users", loadChildren: () => import('./users/users.module').then(m => m.UsersModule) },
  { path: "subjects", loadChildren: () => import('./subjects/subjects.module').then(m => m.SubjectsModule) },
  { path: '**', pathMatch: 'full', component: HomeComponent } // catch any unfound routes and redirect to home page
];

@NgModule({
  imports: [ RouterModule.forRoot(app_routes) ],
  exports: [ RouterModule ],
  providers: []
})
export class AppRoutingModule { }
