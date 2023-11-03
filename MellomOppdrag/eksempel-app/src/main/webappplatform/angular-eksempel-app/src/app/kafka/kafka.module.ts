import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { KafkaRoutingModule } from './kafka-routing.module';

@NgModule({
  imports:      [ SharedModule, KafkaRoutingModule ],
  declarations: [ KafkaRoutingModule.components ]
})
export class KafkaModule { }
