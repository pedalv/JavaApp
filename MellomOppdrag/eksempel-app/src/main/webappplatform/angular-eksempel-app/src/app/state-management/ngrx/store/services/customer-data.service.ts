import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError, Observable } from 'rxjs';
import { catchError, delay, map } from 'rxjs/operators';
//import { Customer } from '../../../../core/model/customer';
import { DataServiceError } from './data-error.service';
import { environment } from '../../../../../environments/environment';

import { DataService } from '../../../../core/services/data.service';
import { ICustomer } from '../../../../shared/interfaces';

@Injectable()
export class CustomerDataService {

  apiUrlBase = environment.apiUrlBase;

  constructor(private http: HttpClient,
              private dataService: DataService) {}

  getCustomers(): Observable<ICustomer[]> {

    //TODO
    //4
    console.log("HERE");
    return this.dataService.getCustomers();

    //Det finnes ikke : ${this.apiUrlBase}/customers
    /*
    return this.http.get<Customer[]>(`${this.apiUrlBase}/customers`)
    .pipe(
      catchError(this.handleError())
    );
    */

  }

  getCustomer(id: number): Observable<ICustomer> {
    return this.http.get<ICustomer>(`${this.apiUrlBase}/customers/${id}`)
    .pipe(
      catchError(this.handleError())
    );
  }

  addCustomer(customer: ICustomer): Observable<ICustomer> {
    return this.http.post<ICustomer>(`${this.apiUrlBase}/customers/`, customer)
    .pipe(
      catchError(this.handleError(customer))
    );
  }

  deleteCustomer(customer: ICustomer): Observable<ICustomer> {
    return this.http.delete(`${this.apiUrlBase}/customers/${customer.id}`)
    .pipe(
      map(() => customer),
      catchError(this.handleError(customer))
    );
  }

  updateCustomer(customer: ICustomer): Observable<ICustomer> {
    return this.http.put<ICustomer>(`${this.apiUrlBase}/customers/${customer.id}`, customer)
    .pipe(
      map(() => customer),
      catchError(this.handleError(customer))
    );
  }

  private handleError<T>(requestData?: T) {
    return (res: HttpErrorResponse) => {
      const error = new DataServiceError(res.error, requestData);
      console.error(error);
      // return new ErrorObservable(error);
      return throwError(error);
    };
  }
}
