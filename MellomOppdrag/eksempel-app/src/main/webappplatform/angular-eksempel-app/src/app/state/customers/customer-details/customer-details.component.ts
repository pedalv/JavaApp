import { Component, OnInit, Input, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer } from '../../../shared/interfaces';

import { NgForm, NgModel } from '@angular/forms';

//import * as CustomerActions  from '../state/customer.actions';
import { CustomerPageActions } from '../state/actions'


import $ from "jquery";

import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { State, getCustomerSelected } from '../state';

/* NgRx */
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush //checkOnce: @Input or @Output only
})
export class CustomerDetailsComponent implements OnInit {

  customer$: Observable<ICustomer>;
  customer: ICustomer;
  id_db: number;

  //Create a copy
  customerSettings : ICustomer;

  isdetails: boolean;

  constructor(private store: Store<State>) {}

  ngOnInit(): void {
    console.log("customer details")
    this.isdetails = true;

    // Use 5: getCustomerSelected
    this.customer$ = this.store.select(getCustomerSelected)
      .pipe(
        tap(customerSelected => this.customer = customerSelected),
        tap( (c) => {
          console.log(c);

          //Create a copy
          this.customerSettings = { ...c };

          if(c && c.id === 0) {
            $("#del").prop("disabled",true);
          }

          this.id_db = c && c.id > 0 ? c.id : 0; //Selected

        })
      );

    //USE 7 : clearCustomer
    //this.store.dispatch(CustomerActions.clearCustomer()); //Store
  }

  edit() : void {
    console.log("Change");
    console.log(this.customer);
    this.isdetails = !this.isdetails;
    this.id_db = parseInt(this.customer.project.split('-').pop());
    if(this.customer.id > 0){
      this.id_db = this.customer.id;
    }
    console.log(this.id_db);
  }

  save(customer:ICustomer) : void {
    console.log("Change Save customer");
    console.log(this.customer);
    this.isdetails = !this.isdetails;

    if(customer.id === 0) {
      //Create
      customer.id = this.id_db;
      console.log(this.customer);
      this.store.dispatch(CustomerPageActions.createCustomer({ customer }));
    } else {
      //Update
      this.store.dispatch(CustomerPageActions.updateCustomer({ customer }));
    }
  }

  cancel(): void {
    console.log("Cancel");
    this.isdetails = true;
    console.log(this.customer);
  }

  delete() : void {
    console.log("Delete");
    console.log(this.customer);
    if (this.customer && this.customer.id) {
      if (confirm(`Really delete the customer: ${this.customer.name}?`)) {
        this.store.dispatch(CustomerPageActions.deleteCustomer({ customerId: this.customer.id }));
      }
    } else {
      // No need to delete, it was never saved
      this.store.dispatch(CustomerPageActions.clearSelectedCustomer());
    }
  }

  onSubmit(form: NgForm) {
    console.log('in onSubmit: ', form.valid);

    console.log(this.id_db);
    console.log(form.value);
    console.log(form.value.name);
    console.log(form.value.project);

    this.customer = {
      id: this.id_db,
      name: form.value.name,
      project: form.value.project
    }
    console.log(this.customer);
    this.save(this.customer);
  }

  onBlur(field: NgModel) {
    console.log('in onBlur:', field.valid);
  }

}

/*

Save Action
Save Success
Save Feil

*/


/*
  input (Send)                            output (Subscribe === EventEmitter)
  input (Send === dispatch === Action)    output (Subscribe === selector === View)
*/
