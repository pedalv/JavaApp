import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Employee } from '../domain/employee';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiURL: string = '/api/employee/all';
  public first: string = "";
  public prev: string = "";
  public next: string = "";
  public last: string = "";

  constructor(private httpClient: HttpClient) {

  }

  public createEmployee(employee: Employee){
    return this.httpClient.post('${this.apiURL}/employees/', employee);
  }

  public updateEmployee(employee: Employee){
    return this.httpClient.put('${this.apiURL}/employees/${Employee.id}', employee);
  }

  public fetchEmployee(id: number){
    return this.httpClient.get('${this.apiURL}/employees/${id}');
  }

  public fetchEmployees(){
    console.log("Get all employees" );
    return this.httpClient.get<Employee[]>('${this.apiURL}/all');
  }

  public deleteEmployee(id: number){
    return this.httpClient.delete(`${this.apiURL}/employees/${id}`);
  }

/*
  public getFirstPage(){
      return this.httpClient.get<Employee[]>('${this.apiURL}/employees?_page=1',{ observe: 'response' })
        .pipe(tap(res => {
          const Link  = this.parse_link_header(res.headers.get('Link'));
          this.first  = Link["first"];
          this.last   = Link["last"];
          this.prev   = Link["prev"];
          this.next   = Link["next"];
        }));
  }
*/

}





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
