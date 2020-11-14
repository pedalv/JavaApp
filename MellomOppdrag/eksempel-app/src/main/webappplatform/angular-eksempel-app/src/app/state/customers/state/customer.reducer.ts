/* NgRx */
import { createReducer, on, createAction, createFeatureSelector, createSelector } from '@ngrx/store';
import * as AppState from './app.state';
import * as CustomerActions  from './customer.actions';
import { ICustomer } from '../../../shared/interfaces';


export interface State extends AppState.State {
  customers: CustomerState;
}

export interface CustomerState {
  isShowCustomers: boolean,
  customerSelected: ICustomer,
  currentCustomer: ICustomer,
  currentCustomerId: number,
  customerList: ICustomer[]
}

const initialState: CustomerState = {
  isShowCustomers: true,
  customerSelected: null,
  currentCustomer: null,
  currentCustomerId: -1,
  customerList: []
}

const getCustomerFeatureState = createFeatureSelector<CustomerState>('customers');

export const getIsShowCustomers = createSelector(
  getCustomerFeatureState,
  state => state.isShowCustomers
);

export const getInitializeCurrentCustomer = createSelector(
  getCustomerFeatureState,
  state => state.currentCustomer
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
    state.customerList.find(c => c.id === currentCustomerId)
);

export const getCustomerList = createSelector(
  getCustomerFeatureState,
  state => state.customerList
);

export const customerReducer = createReducer<CustomerState>(

  initialState,

  on(CustomerActions.isShowCustomers, (state) : CustomerState => {
      console.log('original state IS: ' + JSON.stringify(state));
      return {
        ...state,
        isShowCustomers: !state.isShowCustomers
      };
    }),

  on(CustomerActions.setCustomerSelected, (state, action) : CustomerState => {
        console.log('original state SET: ' + JSON.stringify(state));
        return {
          ...state,
          customerSelected: action.customer
        };
      }),

  on(CustomerActions.showCustomerSelected, state => {
      console.log('original state SELECTED: ' + JSON.stringify(state));
      return {
        ...state,
        customerSelected: state.customerSelected,
      };
    }),

  on(CustomerActions.initializeCurrentCustomer, (state) : CustomerState => {
        console.log('original state initializeCurrentCustomer: ' + JSON.stringify(state));
        return {
          ...state,
          currentCustomer: {
            id: -1,
            name: 'New Customer',
            project: 'Project'
          }
        };
      }),

  on(CustomerActions.loadCustomersSuccess, (state, action) : CustomerState => {
          console.log('original state LIST: ' + JSON.stringify(state));
          return {
            ...state,
            customerList: action.customers
          };
        })

);

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
    customerReducer
    //Store: customers Action: isShowCustomers
    //Store: customers Action: customersList
    //Store: customer Action: customerSelected === currentCustomerId
    customers: {
       isShowCustomers: true,
       customerSelected: null,
       currentCustomerId: -1,
       customersList: []
     }
*/
