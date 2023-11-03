/*
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
*/

import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { StateManagementRoutingModule } from './state-management-routing.module';

@NgModule({
  imports:      [ SharedModule, StateManagementRoutingModule ],
  declarations: [ StateManagementRoutingModule.components]
})
export class StateManagementModule { }
