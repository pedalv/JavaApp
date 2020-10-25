import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectionStrategy, SimpleChanges } from '@angular/core';
import { ICustomer2 } from '../../shared/interfaces';
import { EventBusService, EmitEvent, Events } from '../../core/services/event-bus.service';


@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomersListComponent implements OnInit {

  @Input() customers: ICustomer2[];
  @Output() customerSelected = new EventEmitter<ICustomer2>();
  logMessages: string[] = [];

  constructor(private eventbus: EventBusService) { }

  ngOnInit() {}

  ngOnChanges(simpleChanges: SimpleChanges) {
    if (simpleChanges['customers']) {
      this.logMessages.push('ngOnChanges Fired: Customers changed');
    }
  }

  selectCustomer(cust: ICustomer2) {
    // send to parent via output property
    // note: could use eventbus as well if desired but output property
    // would be the preferred method for passing data to am immediate parent
    this.customerSelected.emit(cust);
    // Send customer to any eventbus listeners listening for the CustomerSelected event
    this.eventbus.emit(new EmitEvent(Events.CustomerSelected, cust));
  }

}
