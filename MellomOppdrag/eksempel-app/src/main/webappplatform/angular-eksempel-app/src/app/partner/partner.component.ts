import { Component, OnInit } from '@angular/core';

import { IPartner } from '../shared/interfaces';

@Component({
  selector: 'app-partner',
  templateUrl: './partner.component.html',
  styleUrls: ['./partner.component.less']
})
export class PartnerComponent implements OnInit {


 //TODO: hent fra database late (see Employee)
 partner : IPartner = {id: null, name: "", description: "", email: ""};

  constructor() { }

  ngOnInit(): void {
  }

  createPartner(){
    console.log("Partner created: ", this.partner);
    this.partner = {id: null, name: "", description: "", email: ""};
    //poc employees is not update
  }

}
