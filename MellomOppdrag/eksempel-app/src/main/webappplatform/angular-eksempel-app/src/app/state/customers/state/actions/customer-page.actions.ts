/* NgRx */
import { createAction, props } from '@ngrx/store';

import { ICustomer } from '../../../../shared/interfaces';


export const toggleShowCustomerFlag = createAction(
    '[Customers Page] Toggle Show Customer Flag'
  );

export const setSelectedCustomer = createAction(
    '[Customer Page] Set Selected Customer',
    props<{ customerSelectedId: number }>()
  );

export const clearSelectedCustomer = createAction(
  '[Product Page] Clear Selected Product'
);

export const initializeSelectedCustomer = createAction(
    '[Customer Page] Initialize Selected Customer'
  );

//Load list of customers
export const loadCustomers = createAction(
    '[Customers Page] Load'
  );

// Update customer
export const updateCustomer = createAction(
  '[Customer Page] Update Customer',
  props<{ customer: ICustomer }>()
);

// Create
export const createCustomer = createAction(
  '[Customer Page] Create Customer',
  props<{ customer: ICustomer }>()
);

// Delete
export const deleteCustomer = createAction(
  '[Customer Page] Delete Customer',
  props<{ customerId: number }>()
);
