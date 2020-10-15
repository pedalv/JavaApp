import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { PartnerRoutingModule } from './partner-routing.module';

@NgModule({
  imports:      [ SharedModule, PartnerRoutingModule ],
  declarations: [ PartnerRoutingModule.components ]
})
export class PartnerModule { }
