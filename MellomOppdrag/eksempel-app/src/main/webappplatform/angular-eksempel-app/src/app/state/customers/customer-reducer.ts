/* NgRx */
import { createReducer, on, createAction } from '@ngrx/store';
import { ICustomer } from '../../shared/interfaces';

export const customerReducer = createReducer(
  {
      isShowCustomers: true,
      customersList: [],
      customerSelected: null
   }, //initialState

  on(createAction('[Customers] IS Show Customers'), state => {
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
      customerSelected | customer: [],
      customers: {}
    }
*/
