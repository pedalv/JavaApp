import { NgModule, Optional, SkipSelf } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { EnsureModuleLoadedOnceGuard } from './ensure-module-loaded-once.guard';

import { HeaderComponent } from './header/header.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';

//import { CloneService } from './services/clone.service';
// import { DataService } from './services/data.service';
// import { ClonerService } from './services/cloner.service';
// import { EventBusService } from './services/event-bus.service';
// import { HttpClientRxJSService } from './services/httpClientRxJS.service';


@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule
  ],
  exports: [
    RouterModule,
    HttpClientModule,
    HeaderComponent,
    NavComponent,
    FooterComponent
  ],
  declarations: [
    HeaderComponent,
    NavComponent,
    FooterComponent
  ],
  providers: [
    /* DataService, ClonerService, EventBusService, HttpClientRxJSService, */
  ] // these should be singleton
})
export class CoreModule extends EnsureModuleLoadedOnceGuard {    // Ensure that CoreModule is only loaded into AppModule

  // Looks for the module in the parent injector to see if it's already been loaded (only want it loaded once)
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    super(parentModule);
    if (parentModule) {
      throw new Error(
        'Core is already loaded. Import it in the AppModule only');
    }
  }

}
