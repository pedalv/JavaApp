import { Component, OnInit } from '@angular/core';
import { KafkaService } from '../services/kafka.service';
import $ from "jquery";

@Component({
  selector: 'app-kafka',
  templateUrl: './kafka.component.html',
  styleUrls: ['./kafka.component.less']
})
export class KafkaComponent implements OnInit {

  isSend : boolean = false;
  hasSendError: boolean = false;
  sendError: String = 'Feil! Kafka tjene er ned!';
  message: String = '';

  constructor(private service:KafkaService) {
  }

  ngOnInit(): void {
  }

  changeMsg(event) {
    this.message = event.target.value;
  }

  SendKafkaMessage(){
    $( "#load" ).even().removeClass( "invisible" );
    $( "#send" ).hide();

    this.service.sendMessages(this.message)
    .subscribe(
      data => {
        $( "#load" ).even().addClass( "invisible" );
        $( "#send" ).show();
        this.isSend = true;
        console.log("Send!");
        console.log(data);
      },
      error => {
        $( "#load" ).even().addClass( "invisible" );
        $( "#send" ).show();
        this.hasSendError = true;
        console.error("Feil! Kafka tjene er ned!");
      }
    );
  }

}