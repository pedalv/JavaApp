import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

import { Observable } from 'rxjs';
import { State, getCustomers } from '../state';

//import * as CustomerActions  from '../state/customer.actions';
import { CustomerPageActions } from '../state/actions'

import $ from "jquery";

/* NgRx */
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush //checkOnce: @Input or @Output only
})
export class CustomersListComponent implements OnInit {

  customers$: Observable<ICustomer[]>; //Subscribe

  constructor(private store: Store<State>) {}

  ngOnInit(): void {
    // Use 6: view - getCustomers
    this.customers$ = this.store.select(getCustomers); //Store
  }

  selected(customer: ICustomer) : void {
    console.log("customer selected");
    $("#del").prop("disabled",false);
    console.log(customer);
    //USE 1 : setSelectedCustomer
    this.store.dispatch(CustomerPageActions.setSelectedCustomer( { customerSelectedId: customer.id } )); //Store
  }

}

/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
