import { Injectable } from '@angular/core';

import { mergeMap, map, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { DataService } from '../../core/services/data.service';

/* NgRx */
import { Actions, createEffect, ofType } from '@ngrx/effects';
import * as CustomerActions from './customer.actions';

@Injectable()
export class CustomerEffects {

  constructor(private actions$: Actions, private customerService: DataService) { }

  loadProducts$ = createEffect(() => {
    return this.actions$
      .pipe(
        ofType(CustomerActions.loadCustomers),
        mergeMap(() => this.customerService.getCustomers()
          .pipe(
            map(customers => CustomerActions.loadCustomersSuccess({ customers })),
            catchError(error => of(CustomerActions.loadCustomersFailure({ error })))
          )
        )
      );
  });
}

/*
- mergeMap: merge data into a observable
*/

/*
    this.dataService.getCustomers()
      .subscribe((custs: ICustomer[]) =>{
        this.customers = custs;
        console.log("getCustomers");
        console.log(this.customers);
      });
*/
