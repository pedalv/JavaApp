import { NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { EnsureModuleLoadedOnceGuard } from './ensure-module-loaded-once.guard';

//import { HeaderComponent } from './header/header.component';
//import { NavComponent } from './nav/nav.component';
//import { HomeComponent } from './home/home.component';
//import { KafkaComponent } from './kafka/kafka.component';
//import { LoginComponent } from './users/login/login.component';
//import { PartnerComponent } from './partner/partner.component';
//import { EmployeeComponent } from './employee/employee.component';
//import { CustomerComponent } from './customer/customer.component';
//import { FooterComponent } from './footer/footer.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule
  ],
  exports: [
    RouterModule,
    HttpClientModule
  ],
  declarations: [
    //HeaderComponent,
    //NavComponent,
    //HomeComponent,
    //KafkaComponent,
    //LoginComponent,
    //PartnerComponent,
    //CustomerComponent,
    //EmployeeComponent,
    //FooterComponent
  ],
  providers: [ ] // these should be singleton
})
export class CoreModule extends EnsureModuleLoadedOnceGuard {    // Ensure that CoreModule is only loaded into AppModule

  // Looks for the module in the parent injector to see if it's already been loaded (only want it loaded once)
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    super(parentModule);
  }

}
