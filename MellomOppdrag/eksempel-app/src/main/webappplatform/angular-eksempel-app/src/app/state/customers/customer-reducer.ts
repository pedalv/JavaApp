/* NgRx */
import { createReducer, on, createAction } from '@ngrx/store';
import { ICustomer } from '../../shared/interfaces';

export const customerReducer = createReducer(
  {
      showCustomersList: true,
      //customersList: [],
      //customerSelected: null
   }, //initialState

  on(createAction('[Customers] Show Customers List'), state => {
    console.log('original state [Customers] Show Customers List: ' + JSON.stringify(state));
    return {
      ...state,
      //customers: state.customersList,
      showCustomersList: !state.showCustomersList
    };
  }),
  on(createAction('[Customer] Show Customer Selected'), state => {
      console.log('original state [Customer] Show Customer Selected: ' + JSON.stringify(state));
      return {
        ...state,
        //customer: state.customerSelected,
        showCustomersList: !state.showCustomersList
      };
    }),
);



/*
    //customerReducer
    //Store: customers Action: showCustomersList
    //Store: customer Action: showSelectedCustomer
    customers: {
      customerSelected | customer: [],
      customers: {}
    }
    */
