import { NgModule } from '@angular/core';

import { KafkaRoutingModule } from './kafka-routing.module';

@NgModule({
  imports:      [ KafkaRoutingModule ],
  declarations: [ KafkaRoutingModule.components ]
})
export class KafkaModule { }
