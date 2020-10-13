import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { PartnerComponent } from './partner/partner.component';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { KafkaComponent } from './kafka/kafka.component';
import { NgpSortModule } from "ngp-sort-pipe";
import { SortDirective } from './directive/sort.directive';
//import { SortByPipe } from "./pipe/sort-by-pipe"; //error Pipe Class Module check

@NgModule({
  declarations: [
    AppComponent,
    PartnerComponent,
    CustomerComponent,
    EmployeeComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    KafkaComponent,
    SortDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgpSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
