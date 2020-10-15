import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { KafkaComponent } from './kafka.component';

const routes: Routes = [
  { path: "", component: KafkaComponent }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ],
  declarations: [  ]
})
export class KafkaRoutingModule {
  static components = [ KafkaComponent ];
}
