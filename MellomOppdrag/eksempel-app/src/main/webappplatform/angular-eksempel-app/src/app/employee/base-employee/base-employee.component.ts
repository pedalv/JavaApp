import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';


@Component({
  selector: 'app-base-employee-component',
  template: '',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class BaseEmployeeComponent implements OnInit {

  constructor() {

  }

  rolles = [
       {id: 1, name: "Seniorutvikler"},
       {id: 2, name: "Leader"},
       {id: 3, name: "Administrasjon"}
  ];

  ngOnInit(): void {
  }

}
