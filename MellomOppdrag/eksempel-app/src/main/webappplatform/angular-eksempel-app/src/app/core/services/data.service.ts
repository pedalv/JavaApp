import { Injectable } from '@angular/core';

import { Observable, of, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';
import { ICustomer } from '../../shared/interfaces';
import { ClonerService } from './cloner.service';
import { List } from 'immutable';

import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
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

  immutableCustomers = List<ICustomer>();

  private customersSubject$ = new BehaviorSubject<ICustomer[]>(this.customers);
  customersChanged$ = this.customersSubject$.asObservable();

  constructor(private cloner: ClonerService) { }

  getCustomers() : Observable<ICustomer[]> {
    console.log("Service: getCustomers() - this.customers");
    // Use the following code if using immutable.js
    // return of(this.immutableCustomers.toJS());
    // return throwError("Feil get customers");
    return of(this.customers);
  }

  addCustomer() : Observable<ICustomer[]> {
    console.log("Service: addCustomer() - this.customers");
    let id = this.customers[this.customers.length - 1].id + 1;
    this.customers.push({
      id: id,
      name: 'New Customer ' + id,
      project: 'Project ' + id
    });
    console.log(this.customers);
    this.customersSubject$.next(this.customers);
    return of(this.customers);
  }

  addCustomerClone() : Observable<ICustomer[]> {
    console.log("Service: addCustomerClone() - this.customers CLONE");
    return this.addCustomer().pipe(
      map(custs => {
        console.log("addCustomerClone");
        console.log(custs);
        return this.cloner.deepClone(custs);
      })
    )
  }

  //NOT USER
  addCustomerImmutable() : Observable<ICustomer[]> {
    console.log("Service: addCustomerImmutable() - this.immutableCustomers");
    let id = this.immutableCustomers[this.immutableCustomers.size - 1].id + 1;
    this.immutableCustomers.push({
      id: id,
      name: 'New Customer ' + id,
      project: 'Project ' + id
    });
    console.log("addCustomerImmutable");
    console.log(this.customers);
    console.log(this.immutableCustomers);
    console.log("TODO");
    this.customersSubject$.next(this.customers);
    return of(this.immutableCustomers.toJS());
  }

  updateCustomer(customer): Observable<ICustomer> {
    console.log("Service: updateCustomer() - this.immutableCustomers");
    console.log(customer);
    this.customersSubject$.next(this.customers);
    return of(customer);
  }

  createCustomer(customer): Observable<ICustomer> {
    console.log("Service: createCustomer() - this.customers");
    console.log(customer);
    this.customersSubject$.next(this.customers);
    return of(customer);

    /*

        const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        // Product Id must be null for the Web API to assign an Id
        const newProduct = { ...product, id: null };
        return this.http.post<Product>(this.productsUrl, newProduct, { headers })
          .pipe(
            tap(data => console.log('createProduct: ' + JSON.stringify(data))),
            catchError(this.handleError)
          );



          public createEmployee(employee: Employee) : Observable<Object> {

              let obj= {
                 "firstName":employee.firstName,
                 "lastName":employee.lastName,
                 "role":employee.role
              };

              //for REST-API
              return this.httpClient.post(this.apiURL + '/add', obj, this.headers);

              eller

              //for STORE | STATE
              return this.httpClient.post<Customer>(this.apiURL + '/add', obj, this.headers)
                         .pipe(
                           tap(data => console.log('createCustomer: ' + JSON.stringify(data))),
                           catchError(this.handleError)
                         );

            }

    */


  }

  deleteCustomer(id: number): Observable<{}> {
    console.log("Service: deleteProduct() - this.immutableCustomers");
    console.log(id);
    console.log(this.customers);

    this.customersSubject$.next(this.customers);
    return of(id);

     /*

      const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      const url = `${this.productsUrl}/${id}`;
      return this.http.delete<Customer>(url, { headers })
        .pipe(
          tap(data => console.log('deleteProduct: ' + id)),
          catchError(this.handleError)
        );


        public deleteEmployee(id: number) : Observable<Object> {
            //for REST-api
            return this.httpClient.delete(this.apiURL + "/" + id);

            eller

            //for STORE | STATE
            return this.httpClient.delete<Customer>(this.apiURL + "/" + id)
                      .pipe(
                        tap(data => console.log('deleteCustomer: ' + id)),
                        catchError(this.handleError)
                      );

          }

      */
      this.customers
    }

}





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
