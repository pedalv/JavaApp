import { NgModule } from '@angular/core';

//import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { UsersRoutingModule } from './users-routing.module';

@NgModule({
  imports:      [ SharedModule, UsersRoutingModule ],
  declarations: [ UsersRoutingModule.components ] //LoginComponent
})
export class UsersModule { }
