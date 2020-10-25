import { Injectable } from '@angular/core';

import { Observable, of, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

import { ICustomer2, IProduct } from '../../shared/interfaces';
import { ClonerService } from './cloner.service';
import { List } from 'immutable';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  customers: ICustomer2[] = [
    {
      id: 1,
      name: 'John Doe',
      city: 'Phoenix',
      age: 42
    },
    {
      id: 2,
      name: 'Jane Doe',
      city: 'Seattle',
      age: 30
    },
    {
      id: 3,
      name: 'Michelle Thompson',
      city: 'Orlando',
      age: 22
    }
  ];

  products: IProduct[] =  [
    {
      id: 1,
      name: 'Basketball',
      price: 29.99
    },
    {
      id: 2,
      name: 'XBox',
      price: 249.99
    },
    {
      id: 3,
      name: 'Nintendo Switch',
      price: 249.99
    },
    {
      id: 4,
      name: 'Bat',
      price: 29.99
    },
    {
      id: 5,
      name: 'Glove',
      price: 29.99
    },
    {
      id: 6,
      name: 'Cell Phone',
      price: 799.99
    },
    {
      id: 7,
      name: 'Cell Phone Service',
      price: 49.99
    },
    {
      id: 8,
      name: 'Laptop',
      price: 999.99
    },
    {
      id: 9,
      name: 'Bluetooth Speaker',
      price: 69.99
    },
    {
      id: 10,
      name: 'TV',
      price: 1599.99
    }
  ];

  immutableCustomers = List<ICustomer2>();
  immutableProducts = List<IProduct>();

  private customersSubject$ = new BehaviorSubject<ICustomer2[]>(this.customers);
  customersChanged$ = this.customersSubject$.asObservable();

  constructor(private cloner: ClonerService) { }

  getCustomers() : Observable<ICustomer2[]> {
    // Use the following code if using immutable.js
    // return of(this.immutableCustomers.toJS());

    return of(this.customers);
  }

  getProducts() : Observable<IProduct[]> {
    // Use this for immutable.js
    // return of(this.immutableProducts.toJS());

    return of(this.products);
  }

  addCustomer() : Observable<ICustomer2[]> {
    let id = this.customers[this.customers.length - 1].id + 1;
    this.customers.push({
      id: id,
      name: 'New Customer ' + id,
      city: 'Somewhere',
      age: id * 5
    });
    this.customersSubject$.next(this.customers);
    return of(this.customers);
  }

  addCustomerClone() : Observable<ICustomer2[]> {
    return this.addCustomer().pipe(
      map(custs => {
        return this.cloner.deepClone(custs);
      })
    )
  }

  addCustomerImmutable() : Observable<ICustomer2[]> {
    let id = this.immutableCustomers[this.immutableCustomers.size - 1].id + 1;
    this.immutableCustomers.push({
      id: id,
      name: 'New Customer ' + id,
      city: 'Somewhere',
      age: id * 5
    });
    this.customersSubject$.next(this.customers);
    return of(this.immutableCustomers.toJS());
  }

  addProduct(newProduct: IProduct) {
    this.products.push({
      id: this.products.length,
      name: newProduct.name,
      price: +newProduct.price
    });
    return of(this.products);
  }

}
