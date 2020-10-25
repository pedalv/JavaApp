//import { ModuleWithProviders } from '@angular/core';
//import { Routes } from '@angular/router';


export interface IEmployee {
  id: number;
  firstName: string;
  lastName: string;
  role: string;
}

export interface IPartner {
  id: number;
  name: string;
  description: string;
  email: string;
}

export interface ICustomer2 {
    id: number;
    name: string;
    city: string;
    age: number;
}

export interface IProduct {
    id: number;
    name: string;
    price: number;
}

export interface ICustomerSubject {
  name: string;
  city: string;
}

export interface ICustomer {
    id: number;
    firstName: string;
    lastName: string;
    gender: string;
    address: string;
    city: string;
    state: IState;
    orders?: IOrder[];
    orderTotal?: number;
    latitude?: number;
    longitude?: number;
}

export interface IOrder {
    productName: string;
    itemCost: number;
}

export interface IOrderItem {
    id: number;
    productName: string;
    itemCost: number;
}

export interface IState {
    abbreviation: string;
    name: string;
}

export interface IPagedResults<T> {
    totalRecords: number;
    results: T;
}

export interface IApiResponse {
    status: boolean;
    error?: string;
}

export interface IMapDataPoint {
    longitude: number;
    latitutde: number;
    markerText?: string;
}

export interface IUserLogin {
    email: string;
    password: string;
}

