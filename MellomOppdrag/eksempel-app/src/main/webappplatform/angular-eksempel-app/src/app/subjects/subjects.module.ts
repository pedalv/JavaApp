import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { SubjectsRoutingModule } from './subjects-routing.module';

@NgModule({
  imports: [ SharedModule, SubjectsRoutingModule ],
  declarations: [ SubjectsRoutingModule.components ]
})
export class SubjectsModule { }
