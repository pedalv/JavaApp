import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

//import { LoginModule } from './login/login.module';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';

import { HomeComponent } from './home/home.component';

/* NgRx */
import { StoreModule } from '@ngrx/store';

@NgModule({
  imports: [
    BrowserModule,
    //LoginModule,                // Eager loaded since we may need to go here right away as browser loads based on route user enters
    AppRoutingModule,             // Main routes for application
    CoreModule,                   // Singleton objects (services, components that are loaded only once, etc.)
    SharedModule,
    StoreModule.forRoot({}, {})   // Shared (multi-instance) objects
  ],
  declarations: [
    AppComponent,
    HomeComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
