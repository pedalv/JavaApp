/* NgRx */
import { createReducer, on, createAction, createFeatureSelector, createSelector } from '@ngrx/store';
import * as AppState from '../app.state';
import { ICustomer } from '../../shared/interfaces';

export interface State extends AppState.State {
  customers: CustomerState;
}

export interface CustomerState {
  isShowCustomers: boolean,
  customerSelected: ICustomer,
  currentCustomerId: number,
  customersList: ICustomer[]
}

const initialState: CustomerState = {
  isShowCustomers: true,
  customerSelected: null,
  currentCustomerId: -1,
  customersList: []
}

const getCustomerFeatureState = createFeatureSelector<CustomerState>('customers');

export const getIsShowCustomers = createSelector(
  getCustomerFeatureState,
  state => state.isShowCustomers
);

export const getCustomerSelected = createSelector(
  getCustomerFeatureState,
  state => state.customerSelected
);

export const getCurrentCustomerId = createSelector(
  getCustomerFeatureState,
  state => state.currentCustomerId
);
export const getCurrentCustomer = createSelector(
  getCustomerFeatureState,
  getCurrentCustomerId,
  (state, currentCustomerId) =>
    state.customersList.find(c => c.id === currentCustomerId)
);

export const getCustomersList = createSelector(
  getCustomerFeatureState,
  state => state.customersList
);

export const customersReducer = createReducer<CustomerState>(

  initialState,

  on(createAction('[Customers] IS Show Customers'), (state) : CustomerState => {
      console.log('original state IS: ' + JSON.stringify(state));
      return {
        ...state,
        isShowCustomers: !state.isShowCustomers
      };
    }),

  on(createAction('[Customers] Show Customers List'), state => {
    console.log('original state LIST: ' + JSON.stringify(state));
    return {
      ...state,
      customersList: state.customersList,
    };
  }),

  on(createAction('[Customer] Show Customer Selected'), state => {
      console.log('original state SELECTED: ' + JSON.stringify(state));
      return {
        ...state,
        customerSelected: state.customerSelected,
      };
    })

);

/*
    customerReducer
    //Store: customers Action: isShowCustomers
    //Store: customers Action: showCustomersList
    //Store: customer Action: showSelectedCustomer
    customers: {
       isShowCustomers: true,
       customerSelected: null,
       currentCustomerId: -1,
       customersList: []
     }
*/
