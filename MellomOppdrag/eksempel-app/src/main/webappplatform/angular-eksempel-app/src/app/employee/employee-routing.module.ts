import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmployeeComponent } from './employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeListSortComponent } from './employee-list-sort/employee-list-sort.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

const routes: Routes = [
  {
    path: "",
    component: EmployeeComponent,
    children: [
      { path: 'list', component: EmployeeListComponent },
      { path: 'list-sort', component: EmployeeListSortComponent },
      { path: 'create', component: EmployeeCreateComponent },
    ]
  }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ],
  declarations: [  ]
})
export class EmployeeRoutingModule {
  static components = [ EmployeeComponent, EmployeeListComponent,  EmployeeListSortComponent, EmployeeCreateComponent, EmployeeDetailsComponent];
}
