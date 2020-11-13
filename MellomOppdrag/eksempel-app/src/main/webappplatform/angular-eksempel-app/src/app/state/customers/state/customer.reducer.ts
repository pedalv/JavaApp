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
  customersList: ICustomer[]
}

const initialState: CustomerState = {
  isShowCustomers: true,
  customerSelected: null,
  currentCustomer: null,
  currentCustomerId: -1,
  customersList: []
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
    state.customersList.find(c => c.id === currentCustomerId)
);

export const getCustomersList = createSelector(
  getCustomerFeatureState,
  state => state.customersList
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

  on(CustomerActions.showCustomersList, state => {
    console.log('original state LIST: ' + JSON.stringify(state));
    return {
      ...state,
      customersList: state.customersList,
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
      })

);

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
