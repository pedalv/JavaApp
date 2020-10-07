import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../domain/employee';
import { tap } from 'rxjs/operators';
import {Observable} from 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiURL: string = '/api/employee';
  public first: string = "";
  public prev: string = "";
  public next: string = "";
  public last: string = "";

  constructor(private httpClient: HttpClient) {

  }

  public createEmployee(employee: Employee) : Observable<Object> {
    console.log("Create employee" + employee);
    const params = new URLSearchParams();
    //params.append("id", employee.id);
    params.append("firstName", employee.firstName);
    params.append("lastName", employee.lastName);
    params.append("role", employee.role);
     console.log(this.apiURL + '/add?' + params);
    return this.httpClient.post(this.apiURL + '/add?', params); //TODO: 403Forbidden

  }

  public updateEmployee(employee: Employee) : Observable<Object>  {
    return this.httpClient.put(this.apiURL + '/' + employee.id, employee);
  }

  public singleEmployee(id: number) : Observable<Object> {
    return this.httpClient.get(this.apiURL + '/' + id);
  }

  public allEmployees() : Observable<Employee[]> {
    console.log("Get all employees" );
    console.log(this.apiURL + '/all');
    return this.httpClient.get<Employee[]>(this.apiURL + '/all');
  }

  public deleteEmployee(id: number) : Observable<Object> {
    return this.httpClient.delete(this.apiURL + id);
  }

  public getFirstPage(){
      return this.httpClient.get<Employee[]>(this.apiURL + '?_page=1', { observe: 'response' })
        .pipe(tap(res => {
          const Link  = this.parse_link_header(res.headers.get('Link'));
          this.first  = Link["first"];
          this.last   = Link["last"];
          this.prev   = Link["prev"];
          this.next   = Link["next"];
        }));
  }

  parse_link_header(header) {
    if (header.length == 0) {
      return ;
    }

    let parts = header.split(',');
    var links = {};
    parts.forEach( p => {
      let section = p.split(';');
      var url = section[0].replace(/<(.*)>/, '$1').trim();
      var name = section[1].replace(/rel="(.*)"/, '$1').trim();
      links[name] = url;

    });
    return links;
  }

  public getNextPage(url: string){
        return this.httpClient.get<Employee[]>(url,{ observe: 'response' }).pipe(tap(res => {
          const Link  = this.parse_link_header(res.headers.get('Link'));
          this.first  = Link["first"];
          this.last   = Link["last"];
          this.prev   = Link["prev"];
          this.next   = Link["next"];
        }));
   }


}



//https://www.techiediaries.com/angular-httpclient-headers-full-response/


/*
getUser(firstname): Observable<any> {
    const API_URL = `${SERVICE_URL}/user/firstname/${firstname}`;
    return this.client.get(API_URL, { headers: this.httpOptions }).pipe(
      map((res: Response) => {
        return res || {}
      }),
      catchError(this.handleError)
    )
  }
*/
