/* NgRx */
import { createFeatureSelector, createSelector } from '@ngrx/store';
import * as AppState from './app.state';
import { CustomerState } from './customer.reducer';

export interface State extends AppState.State {
  customers: CustomerState;
}

const getCustomerFeatureState = createFeatureSelector<CustomerState>('customers');

export const getShowCustomerFlag = createSelector(
  getCustomerFeatureState,
  state => state.showCustomerFlag
);
/*
export const getInitializeSelectedCustomer = createSelector(
  getCustomerFeatureState,
  state => state.customerSelectedId
);
*/
export const getCustomerSelectedId = createSelector(
  getCustomerFeatureState,
  state => state.customerSelectedId
);

export const getCustomerSelected = createSelector(
  getCustomerFeatureState,
  getCustomerSelectedId,
  (state, customerSelectedId) => {
    console.log(state.customers.length+1);
    console.log("getCustomerSelected");
    if (customerSelectedId === 0) {
      return {
        id: 0, //new customer to add
        name: 'Name-'+(state.customers.length+1),
        project: 'Project-'+(state.customers.length+1)
      };
    } else {
      return customerSelectedId ? state.customers.find(p => p.id === customerSelectedId) : null;
    }
  }
);

/* DELETEEEEEE
export const getCustomerSelected = createSelector(
  getCustomerFeatureState,
  state => state.customerSelected
);
*/

export const getCustomers = createSelector(
  getCustomerFeatureState,
  state => state.customers
);

export const getError = createSelector(
  getCustomerFeatureState,
  state => state.error
);
