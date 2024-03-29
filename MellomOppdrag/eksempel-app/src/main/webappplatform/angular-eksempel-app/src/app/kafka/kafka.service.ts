import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class KafkaService {

  //https://stackoverflow.com/questions/59486699/localhost4200-has-been-blocked-by-cors-policy-no-access-control-allow-origin
  //https://juristr.com/blog/2016/11/configure-proxy-api-angular-cli/
  //private url : String = 'http://localhost:8080/api/kafka/string?message=';
  private url : string = '/api/kafka/string?message=';


  constructor(private httpClient: HttpClient) { }

   sendMessages(message: string) : Observable<Object> {
      console.log("message: " + message);
      return this.httpClient.get(this.url+message);
   }

}
