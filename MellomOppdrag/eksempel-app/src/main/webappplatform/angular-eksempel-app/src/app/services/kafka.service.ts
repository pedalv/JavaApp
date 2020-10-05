import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KafkaService {

  private url : String = 'http://localhost:8080/kafka/string?message=';

  constructor(private httpClient: HttpClient) { }

   sendMessages(message){
    console.log("message: " + message);
    return this.httpClient.get(this.url+message);
   }

}
