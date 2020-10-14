import { NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';
//import { RouterModule } from '@angular/router';

import { EnsureModuleLoadedOnceGuard } from './ensure-module-loaded-once.guard';
//import { NgpSortModule } from "ngp-sort-pipe";
//import { SortDirective } from '../directive/sort.directive';


//import { HeaderComponent } from './header/header.component';
//import { NavComponent } from './nav/nav.component';
//import { HomeComponent } from './home/home.component';
//import { KafkaComponent } from './kafka/kafka.component';
//import { LoginComponent } from './users/login/login.component';
//import { PartnerComponent } from './partner/partner.component';
//import { EmployeeComponent } from './employee/employee.component';
//import { SortByPipe } from "./pipe/sort-by-pipe"; //error Pipe Class Module check
//import { CustomerComponent } from './customer/customer.component';
//import { FooterComponent } from './footer/footer.component';




@NgModule({
  //imports: [, , , GrowlerModule, ModalModule, OverlayModule],
  //exports: [GrowlerModule, , , ModalModule, OverlayModule, NavbarComponent],
  imports: [
    CommonModule,
    //RouterModule,
    //FormsModule,
    HttpClientModule




  ],
  exports: [
    //RouterModule,
    //HttpClientModule
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


/*
--



import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { GrowlerModule } from './growler/growler.module';
import { ModalModule } from './modal/modal.module';
import { OverlayModule } from './overlay/overlay.module';

import { DataService } from './services/data.service';
import { NavbarComponent } from './navbar/navbar.component';
import { FilterService } from './services/filter.service';
import { SorterService } from './services/sorter.service';
import { TrackByService } from './services/trackby.service';
import { DialogService } from './services/dialog.service';

import { AuthService } from './services/auth.service';
import { EventBusService } from './services/event-bus.service';
import { AuthInterceptor } from './interceptors/auth.interceptor';


*/
