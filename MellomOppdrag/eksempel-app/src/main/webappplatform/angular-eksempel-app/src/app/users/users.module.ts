import { NgModule } from '@angular/core';

import { UsersRoutingModule } from './users-routing.module';

@NgModule({
  imports:      [ UsersRoutingModule ],
  declarations: [ UsersRoutingModule.components ] //LoginComponent
})
export class UsersModule { }
