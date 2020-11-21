/* NgRx */
import { createAction, props } from '@ngrx/store';

import { ICustomer } from '../../../shared/interfaces';


export const toggleShowCustomerFlag = createAction(
    '[Customers] Toggle Show Customer Flag'
  );

export const setSelectedCustomer = createAction(
    '[Customer] Set Selected Customer',
    props<{ customerSelectedId: number }>()
  );

export const clearSelectedCustomer = createAction(
  '[Product] Clear Selected Product'
);

export const initializeSelectedCustomer = createAction(
    '[Customer] Initialize Selected Customer'
  );

//Load list of customers
export const loadCustomers = createAction(
    '[Customers] Load'
  );
export const loadCustomersSuccess = createAction(
    '[Customers] Load Success',
    props< { customers : ICustomer[] } >()
  );
export const loadCustomersFailure = createAction(
    '[Customers] Load Fail',
    props< { error: string } >()
  );

// Update customer
export const updateCustomer = createAction(
  '[Customer] Update Customer',
  props<{ customer: ICustomer }>()
);
export const updateCustomerSuccess = createAction(
  '[Customer] Update Customer Success',
  props<{ customer: ICustomer }>()
);
export const updateCustomerFailure = createAction(
  '[Customer] Update Customer Fail',
  props<{ error: string }>()
);

// Create
export const createCustomer = createAction(
  '[Customer Page] Create Customer',
  props<{ customer: ICustomer }>()
);

export const createCustomerSuccess = createAction(
  '[Customer API] Create Customer Success',
  props<{ customer: ICustomer }>()
);

export const createCustomerFailure = createAction(
  '[Customer API] Create Customer Fail',
  props<{ error: string }>()
);

// Delete
export const deleteCustomer = createAction(
  '[Customer Page] Delete Customer',
  props<{ customerId: number }>()
);

export const deleteCustomerSuccess = createAction(
  '[Customer Api] Delete Customer Success',
  props<{ customerId: number }>()
);

export const deleteCustomerFailure = createAction(
  '[Customer Api] Delete Customer Fail',
  props<{ error: string }>()
);
