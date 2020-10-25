import { Component, OnInit, OnDestroy, Input, Output, EventEmitter, ChangeDetectionStrategy, SimpleChanges } from '@angular/core';
import { ICustomer2 } from '../../shared/interfaces';
import { EventBusService, EmitEvent, Events } from '../../core/services/event-bus.service';
import { DataService } from '../../core/services/data.service';
import { Subscription } from 'rxjs';

import { AutoUnsubscribe } from 'ngx-auto-unsubscribe';

@AutoUnsubscribe()
@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomersListComponent implements OnInit, OnDestroy {

  @Input() customers: ICustomer2[]; //Send
  @Output() customerSelected = new EventEmitter<ICustomer2>(); //Subscribe
  logMessages: string[] = [];

  eventbusSub: Subscription;
  customersChangedSub: Subscription;
  constructor(private eventbus: EventBusService, private dataService: DataService) {}
  //constructor(private eventbus: EventBusService) { }

  ngOnInit() {

    //Example of using BehaviorSubject to be notified when a service changes
    this.customersChangedSub = this.dataService.customersChanged$.subscribe(custs => (this.customers = custs)); //Subscribe

    //Example of using an event bus to provide loosely coupled communication (mediator pattern)
    this.eventbusSub = this.eventbus.on(Events.CustomerSelected, cust => (this.customerSelected = cust)); //Subscribe

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

  selectCustomer(cust: ICustomer2) {
    // send to parent via output property
    // note: could use eventbus as well if desired but output property
    // would be the preferred method for passing data to am immediate parent
    this.customerSelected.emit(cust); //To send an event
    // Send customer to any eventbus listeners listening for the CustomerSelected event
    this.eventbus.emit(new EmitEvent(Events.CustomerSelected, cust)); //To send an event
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
