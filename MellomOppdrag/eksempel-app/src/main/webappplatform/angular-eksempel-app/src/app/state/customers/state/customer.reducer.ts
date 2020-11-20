/* NgRx */
import { createReducer, on, createAction, createFeatureSelector, createSelector } from '@ngrx/store';
import * as AppState from './app.state';
import * as CustomerActions  from './customer.actions';
import { ICustomer } from '../../../shared/interfaces';


export interface State extends AppState.State {
  customers: CustomerState;
}

export interface CustomerState {
  showCustomerFlag: boolean,
  customerSelectedId: number,
  customers: ICustomer[],
  error: string;
}

const initialState: CustomerState = {
  showCustomerFlag: true,
  customerSelectedId: null,
  customers: [],
  error: ''
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
  console.log("getCustomerSelected");
    if (customerSelectedId === 0) {
      return {
        id: 0,
        name: 'New',
        project: ''
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

export const customerReducer = createReducer<CustomerState>(

  initialState,

  on(CustomerActions.toggleShowCustomerFlag, (state) : CustomerState => {
      console.log('Effect CustomerActions toggleShowCustomerFlag: ' + JSON.stringify(state));
      return {
        ...state,
        showCustomerFlag: !state.showCustomerFlag
      };
    }),

  on(CustomerActions.setSelectedCustomer, (state, action) : CustomerState => {
        console.log('Effect CustomerActions setSelectedCustomer: ' + JSON.stringify(state));
        return {
          ...state,
          customerSelectedId: action.customerSelectedId
        };
      }),

  on(CustomerActions.setSelectedCustomer, state => {
      console.log('Effect CustomerActions setSelectedCustomer: ' + JSON.stringify(state));
      return {
        ...state,
        customerSelectedId: state.customerSelectedId,
      };
    }),

  on(CustomerActions.clearSelectedCustomer, (state): CustomerState => {
      console.log("Effect CustomerActions clearSelectedCustomer")
      return {
        ...state,
        customerSelectedId: null
      };
    }),

  on(CustomerActions.initializeSelectedCustomer, (state) : CustomerState => {
        console.log('Effect CustomerActions initializeSelectedCustomer: ' + JSON.stringify(state));
        return {
          ...state,
          customerSelectedId: 0
        };
      }),

  on(CustomerActions.loadCustomersSuccess, (state, action) : CustomerState => {
          console.log('Effect CustomerActions loadCustomersSuccess: ' + JSON.stringify(state));
          return {
            ...state,
            customers: action.customers,
            error: ''
          };
        }),

  on(CustomerActions.loadCustomersFailure, (state, action) : CustomerState => {
            console.log('Effect CustomerActions loadCustomersFailure: ' + JSON.stringify(state));
            return {
              ...state,
              customers: [],
              error: action.error
            };
          }),

  on(CustomerActions.updateCustomerSuccess, (state, action): CustomerState => {
    console.log("Effect CustomerActions updateCustomerSuccess")
    const updatedCustomers = state.customers.map(
      item => action.customer.id === item.id ? action.customer : item);
    return {
      ...state,
      customers: updatedCustomers,
      customerSelectedId: action.customer.id,
      error: ''
    };
  }),

  on(CustomerActions.updateCustomerFailure, (state, action): CustomerState => {
    console.log("Effect CustomerActions updateCustomerFailure")
    return {
      ...state,
      error: action.error
    };
  }),

  // After a create, the currentCustomer is the new customer.
  on(CustomerActions.createCustomerSuccess, (state, action): CustomerState => {
    console.log("Effect CustomerActions createCustomerSuccess")
    return {
      ...state,
      customers: [...state.customers, action.customer],
      customerSelectedId: action.customer.id,
      error: ''
    };
  }),

  on(CustomerActions.createCustomerFailure, (state, action): CustomerState => {
    console.log("Effect CustomerActions createCustomerFailure")
    return {
      ...state,
      error: action.error
    };
  }),

  // After a delete, the currentCustomer is null.
  on(CustomerActions.deleteCustomerSuccess, (state, action): CustomerState => {
    console.log("Effect CustomerActions deleteCustomerSuccess")
    return {
      ...state,
      customers: state.customers.filter(customer => customer.id !== action.customerId),
      customerSelectedId: null,
      error: ''
    };
  }),

  on(CustomerActions.deleteCustomerFailure, (state, action): CustomerState => {
    console.log("Effect CustomerActions deleteCustomerFailure")
    return {
      ...state,
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
    //Store: customers Action: toggleShowCustomers
    //Store: customers Action: customersList
    //Store: customer Action: customerSelected === currentCustomerId
    customers: {
       showCustomerFlag: true,
       customerSelected: null,
       currentCustomerId: -1,
       customersList: []
     }
*/
