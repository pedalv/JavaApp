import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';

import { HomeComponent } from './home/home.component';
import { KafkaComponent } from './kafka/kafka.component';
import { PartnerComponent } from './partner/partner.component';
import { EmployeeComponent } from './employee/employee.component';
import { CustomerComponent } from './customer/customer.component';

@NgModule({
  imports: [
    BrowserModule,
    //LoginModule,        // Eager loaded since we may need to go here right away as browser loads based on route user enters
    AppRoutingModule,     // Main routes for application
    CoreModule,           // Singleton objects (services, components that are loaded only once, etc.)
    SharedModule          // Shared (multi-instance) objects
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    KafkaComponent,
    PartnerComponent,
    CustomerComponent,
    EmployeeComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
