import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomersListComponent implements OnInit {

  @Input() customers: ICustomer[]; //Send
  @Output() customerSelected = new EventEmitter<ICustomer>(); //Subscribe

  constructor() {}

  ngOnInit(): void {
  }

  select(cust: ICustomer) {
    console.log("select - EventEmitter");
    this.customerSelected.emit(cust); //To send an event
  }

}
