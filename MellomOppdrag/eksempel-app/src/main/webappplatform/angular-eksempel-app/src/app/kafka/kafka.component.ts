import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-kafka',
  templateUrl: './kafka.component.html',
  styleUrls: ['./kafka.component.less']
})
export class KafkaComponent implements OnInit {

  isSend : boolean = false;
  hasSendError: boolean = false;
  sendError: String = "Feil! Kafka tjene er ned!"


  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  SendKafkaMessage(){
    //TODO: Url og Service


    this.http.get<any>('https://api.npms.io/v2/invalid-url')
      .subscribe(
          data => {
            this.isSend = true;
            console.log("send: " + this.isSend)
          },
          error => {
            this.hasSendError = true;
            console.error("Feil! Kafka tjene er ned!");
          }
      );


  }

}
