/* NgRx */
import { createAction, props } from '@ngrx/store';

import { ICustomer } from '../../../shared/interfaces';


export const isShowCustomers = createAction(
    '[Customers] IS Show Customers'
  );

export const showCustomerSelected = createAction(
    '[Customer] Show Customer Selected'
  );

export const showCustomerSelectedId = createAction(
    '[Customer] Show Customer Selected Id'
  );

export const setCustomerSelected = createAction(
    '[Customer] Set Customer Selected',
    props<{ customer: ICustomer }>()
  );

export const clearCustomer = createAction(
  '[Product] Clear Product'
);

export const initializeCustomer = createAction(
    '[Customer] Initialize Customer Selected'
  );


export const loadCustomers = createAction(
    '[Customer] Load'
  );
export const loadCustomersSuccess = createAction(
    '[Customer] Load Success',
    props< { customers : ICustomer[] } >()
  );
export const loadCustomersFailure = createAction(
    '[Customer] Load Fail',
    props< { error: string } >()
  );
