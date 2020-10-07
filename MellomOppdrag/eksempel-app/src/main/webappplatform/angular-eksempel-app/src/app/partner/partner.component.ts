import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-partner',
  templateUrl: './partner.component.html',
  styleUrls: ['./partner.component.less']
})
export class PartnerComponent implements OnInit {

  //TODO: hent fra database late
  employee : {id, name, description, email} = {id: null, name: "", description: "", email: ""};

  constructor() { }

  ngOnInit(): void {
  }

  createEmployee(){
    console.log("Employee created: ", this.employee);
    this.employee = {id: null, name: "", description: "", email: ""};
    //poc employees is not update
  }

}
