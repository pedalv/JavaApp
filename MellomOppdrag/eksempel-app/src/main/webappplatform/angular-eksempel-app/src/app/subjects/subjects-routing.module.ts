import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SubjectsComponent } from './subjects.component';

const routes: Routes = [
    { path: '', component: SubjectsComponent }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ],
  declarations: [  ]
})
export class SubjectsRoutingModule {
  static components = [ SubjectsComponent ];
}
