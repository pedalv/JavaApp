import { Injectable } from '@angular/core';

import { mergeMap, map, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { DataService } from '../../../core/services/data.service';

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
- switchMap: merge observable into other observable
=== Use for get request or cancelable request like searches

- concatMap: merge data into a observable in order and is less performant
=== Use for get, post and put request when order is important

- mergeMap: merge data into a observable in parallel
=== Use for get, put, post and delete methods when order is not important

- exchaustMap: Ignores all subsequent subscriprions/requests until is completes
=== Use for login when do not want more requests until the initial one is complete
*/

/*
    this.dataService.getCustomers()
      .subscribe((custs: ICustomer[]) =>{
        this.customers = custs;
        console.log("getCustomers");
        console.log(this.customers);
      });
*/
