import { Injectable } from '@angular/core';

import { Observable, of, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';
//import { Customer } from '../../core/model/customer';
import { ICustomer } from '../../shared/interfaces';
import { ClonerService } from './cloner.service';
import { List } from 'immutable';

@Injectable({
  providedIn: 'root'
})
export class DataService {
/*
  customers2: Customer[] = [
      {
        id: 1,
        name: 'John Doe',
        city: 'Phoenix',
        orderTotal: 42
      },
      {
        id: 2,
        name: 'Jane Doe',
        city: 'Seattle',
        orderTotal: 30
      },
      {
        id: 3,
        name: 'Michelle Thompson',
        city: 'Orlando',
        orderTotal: 22
      }
    ];
*/


/*
Garantikassen for fiskere	GFF ELSAM 2015
NAV/Helsedirektoratet	KUKR/SAPO
Senter for pasientmedvirkning og samhandlingsforskning (SPS)	SpsWebPage, ReConnect-App og -Web
Statnett	Responsive design av internettløsning
Norges Forskningsråd	Forvaltning av nettsider prosjekter
Gjensidige Forsikring	Forvaltning
A-Pressen Digital Medier (Amedia)	Nettaviser, Zett.no
More Software Solutions	Digital Skjema
UDP AS	Involvert i et internt prosjekt
*/
  customers: ICustomer[] = [
    {
      id: 1,
      name: 'NAV',
      project: 'Automastisk Frikort'
    },
    {
      id: 2,
      name: 'Apotek 1',
      project: 'Nagara'
    },
    {
      id: 3,
      name: 'Direktoratet for e-helse',
      project: 'Digital skjema RØF, TOD'
    }
  ];
/*
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
*/
  immutableCustomers = List<ICustomer>();

  private customersSubject$ = new BehaviorSubject<ICustomer[]>(this.customers);
  customersChanged$ = this.customersSubject$.asObservable();

  constructor(private cloner: ClonerService) { }

  getCustomers() : Observable<ICustomer[]> {
    // Use the following code if using immutable.js
    // return of(this.immutableCustomers.toJS());

    return of(this.customers);
  }

  addCustomer() : Observable<ICustomer[]> {
    let id = this.customers[this.customers.length - 1].id + 1;
    this.customers.push({
      id: id,
      name: 'New Customer ' + id,
      project: 'Project ' + id
    });
    console.log("addCustomer");
    console.log(this.customers);
    this.customersSubject$.next(this.customers);
    return of(this.customers);
  }

  addCustomerClone() : Observable<ICustomer[]> {
    return this.addCustomer().pipe(
      map(custs => {
        console.log("addCustomerClone");
        console.log(custs);
        return this.cloner.deepClone(custs);
      })
    )
  }

  addCustomerImmutable() : Observable<ICustomer[]> {
    let id = this.immutableCustomers[this.immutableCustomers.size - 1].id + 1;
    this.immutableCustomers.push({
      id: id,
      name: 'New Customer ' + id,
      project: 'Project ' + id
    });
    console.log("addCustomerImmutable");
    console.log(this.customers);
    this.customersSubject$.next(this.customers);
    return of(this.immutableCustomers.toJS());
  }

}
