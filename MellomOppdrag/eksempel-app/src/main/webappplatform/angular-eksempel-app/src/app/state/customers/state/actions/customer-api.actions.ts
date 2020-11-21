/* NgRx */
import { createAction, props } from '@ngrx/store';

import { ICustomer } from '../../../../shared/interfaces';


//Load list of customers
export const loadCustomersSuccess = createAction(
    '[Customers Api] Load Success',
    props< { customers : ICustomer[] } >()
  );
export const loadCustomersFailure = createAction(
    '[Customers Api] Load Fail',
    props< { error: string } >()
  );

// Update customer
export const updateCustomerSuccess = createAction(
  '[Customer Api] Update Customer Success',
  props<{ customer: ICustomer }>()
);
export const updateCustomerFailure = createAction(
  '[Customer Api] Update Customer Fail',
  props<{ error: string }>()
);

// Create
export const createCustomerSuccess = createAction(
  '[Customer API] Create Customer Success',
  props<{ customer: ICustomer }>()
);
export const createCustomerFailure = createAction(
  '[Customer API] Create Customer Fail',
  props<{ error: string }>()
);

// Delete
export const deleteCustomerSuccess = createAction(
  '[Customer Api] Delete Customer Success',
  props<{ customerId: number }>()
);
export const deleteCustomerFailure = createAction(
  '[Customer Api] Delete Customer Fail',
  props<{ error: string }>()
);
