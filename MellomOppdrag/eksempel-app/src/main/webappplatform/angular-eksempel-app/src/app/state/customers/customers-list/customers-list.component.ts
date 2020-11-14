import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

import { Observable } from 'rxjs';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomersListComponent implements OnInit {

  //@Input() customers: ICustomer[]; //Send
  @Input() customers$: Observable<ICustomer[]>; //Send
  @Output() customerSelected = new EventEmitter<ICustomer>(); //Subscribe

  constructor() {}

  ngOnInit(): void {
  }

  select(cust: ICustomer) {
    console.log("select - EventEmitter");
    this.customerSelected.emit(cust); //To send an event
  }

}

/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
