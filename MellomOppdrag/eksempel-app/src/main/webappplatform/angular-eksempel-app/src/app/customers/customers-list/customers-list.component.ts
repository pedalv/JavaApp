import { Component, OnInit, OnDestroy, Input, Output, EventEmitter, ChangeDetectionStrategy, SimpleChanges } from '@angular/core';
import { ICustomer } from '../../shared/interfaces';
import { EventBusService, EmitEvent, Events } from '../../core/services/event-bus.service';

import { DataService } from '../../core/services/data.service';
import { Subscription } from 'rxjs';

import { AutoUnsubscribe } from 'ngx-auto-unsubscribe';

@AutoUnsubscribe()
@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush //checkOnce: @Input or @Output only
})
export class CustomersListComponent implements OnInit, OnDestroy {

  @Input() customers: ICustomer[]; //Send
  @Output() customerSelected = new EventEmitter<ICustomer>(); //Subscribe
  logMessages: string[] = [];

  eventbusSub: Subscription;
  customersChangedSub: Subscription;

  constructor(private eventbus: EventBusService, private dataService: DataService) {}
  //constructor(private eventbus: EventBusService) { }

  ngOnInit() {
    console.log("ngOnInit");
    //Example of using BehaviorSubject to be notified when a service changes
    this.customersChangedSub = this.dataService.customersChanged$.subscribe(custs => (this.customers = custs)); //Subscribe

    //Example of using an event bus to provide loosely coupled communication (mediator pattern) - Feil etter flere customer
    //this.eventbusSub = this.eventbus.on(Events.Customer_Selected, cust => (this.customerSelected = cust)); //Subscribe

  }

  //TO subscribe an event
  ngOnChanges(simpleChanges: SimpleChanges) {
    console.log("ngOnChanges");
    if (simpleChanges['customers']) {
      this.logMessages.push('ngOnChanges Fired: Customers changed');
    }

    console.log(simpleChanges['customers']);
    console.log(simpleChanges);

  }

  select(cust: ICustomer) {
    console.log("select - EventEmitter");
    console.log(cust);


    // send to parent via output property
    // note: could use eventbus as well if desired but output property
    // would be the preferred method for passing data to am immediate parent
    console.log("-1-");
    this.customerSelected.emit(cust); //To send an event
    console.log("-2-");
    // Send customer to any eventbus listeners listening for the CustomerSelected event
    this.eventbus.emit(new EmitEvent(Events.Customer_Selected, cust)); //To send an event
  }

  ngOnDestroy() {
    // AutoUnsubscribe decorator above makes these calls unnecessary
    /*
    if(this.eventbusSub) {
      this.eventbusSub.unsubscribe();
    }
    if(this.customersChangedSub) {
      this.customersChangedSub.unsubscribe();
    }
    */
    //or SubSink === this.subs.unsubscribe();
  }

}
