import { Component, OnInit } from '@angular/core';
import { KafkaService } from '../services/kafka.service';

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
    this.service.sendMessages(this.message)
    .subscribe(
      data => {
        this.isSend = true;
        console.log("Send!");
        console.log(data);
      },
      error => {
        this.hasSendError = true;
        console.error("Feil! Kafka tjene er ned!");
      }
    );
  }

}
