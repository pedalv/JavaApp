import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KafkaService {

  private url = 'http://jsonplaceholder.typicode.com/posts';

  constructor(private httpClient: HttpClient) { }

   sendMessages(message){
    console.log("message: " + message);
    return this.httpClient.get(this.url);
   }

}
