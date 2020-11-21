import { ICustomer } from '../../../shared/interfaces';
import { createReducer, on} from '@ngrx/store';
import * as CustomerActions  from './customer.actions';

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
