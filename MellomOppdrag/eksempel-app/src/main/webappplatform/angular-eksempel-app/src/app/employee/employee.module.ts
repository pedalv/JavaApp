import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { EmployeeRoutingModule } from './employee-routing.module';
import { BaseEmployeeComponent } from './base-employee/base-employee.component';

@NgModule({
  imports:      [ SharedModule, EmployeeRoutingModule ],
  declarations: [ EmployeeRoutingModule.components, BaseEmployeeComponent ]
})
export class EmployeeModule { }
