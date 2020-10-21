import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeShowComponent } from './employee-show/employee-show.component';

@NgModule({
  imports:      [ SharedModule, EmployeeRoutingModule ],
  declarations: [ EmployeeRoutingModule.components, EmployeeShowComponent]
})
export class EmployeeModule { }
