import { Component, OnInit } from '@angular/core';
import { Employee } from '../domain/employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
})

export class EmployeeComponent implements OnInit {

  selectedEmployee: Employee;

  constructor() { }

  ngOnInit(): void {
  }

  changed(employee: Employee) {
      console.log("CHANGED");
      console.log(employee);
      //this.selectedEmployee = employee;
      this.selectedEmployee = JSON.parse(JSON.stringify(employee)); //Clone ref
  }

}
