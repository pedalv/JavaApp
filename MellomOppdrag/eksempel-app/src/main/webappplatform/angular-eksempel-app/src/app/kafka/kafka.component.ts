import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-kafka',
  templateUrl: './kafka.component.html',
  styleUrls: ['./kafka.component.less']
})
export class KafkaComponent implements OnInit {

  isSend : boolean = false;
  hasSendError: boolean = false;
  sendError: String = "Feil! Kafka tjene er ned!"


  constructor() { }

  ngOnInit(): void {
  }

  SendKafkaMessage(){
    //TODO
    this.hasSendError = false;
    this.isSend = true;
    console.log("send: " + this.isSend)
  }

}
