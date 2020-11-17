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
  customerSelectedId: number,
  customerList: ICustomer[],
  error: string;
}

const initialState: CustomerState = {
  isShowCustomers: true,
  customerSelectedId: null,
  customerList: [],
  error: ''
}

const getCustomerFeatureState = createFeatureSelector<CustomerState>('customers');

export const getIsShowCustomers = createSelector(
  getCustomerFeatureState,
  state => state.isShowCustomers
);

export const getInitializeCustomerSelected = createSelector(
  getCustomerFeatureState,
  state => state.customerSelectedId
);





export const getCustomerSelectedId = createSelector(
  getCustomerFeatureState,
  state => state.customerSelectedId
);

export const getCustomerSelected = createSelector(
  getCustomerFeatureState,
  getCustomerSelectedId,
  (state, customerSelectedId) => {
    if (customerSelectedId === 0) {
      return {
        id: 0,
        name: 'New',
        project: ''
      };
    } else {
      return customerSelectedId ? state.customerList.find(p => p.id === customerSelectedId) : null;
    }
  }
);

/*
export const getCustomerSelected = createSelector(
  getCustomerFeatureState,
  state => state.customerSelected
);
*/

export const getCustomerList = createSelector(
  getCustomerFeatureState,
  state => state.customerList
);

export const getError = createSelector(
  getCustomerFeatureState,
  state => state.error
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
          customerSelectedId: action.customerSelectedId
        };
      }),

  on(CustomerActions.showCustomerSelected, state => {
      console.log('original state SELECTED: ' + JSON.stringify(state));
      return {
        ...state,
        customerSelectedId: state.customerSelectedId,
      };
    }),

  on(CustomerActions.clearCustomer, (state): CustomerState => {
      return {
        ...state,
        customerSelectedId: null
      };
    }),

  on(CustomerActions.initializeCustomer, (state) : CustomerState => {
        console.log('original state initializeCurrentCustomer: ' + JSON.stringify(state));
        return {
          ...state,
          customerSelectedId: 0
        };
      }),

  on(CustomerActions.loadCustomersSuccess, (state, action) : CustomerState => {
          console.log('original state LIST SUCCESS: ' + JSON.stringify(state));
          return {
            ...state,
            customerList: action.customers,
            error: ''
          };
        }),

  on(CustomerActions.loadCustomersFailure, (state, action) : CustomerState => {
            console.log('original state LIST ERROR: ' + JSON.stringify(state));
            return {
              ...state,
              customerList: [],
              error: action.error
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
