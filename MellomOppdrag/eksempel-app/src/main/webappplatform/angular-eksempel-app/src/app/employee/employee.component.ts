import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Employee } from '../domain/employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
  //changeDetection: ChangeDetectionStrategy.OnPush
})

export class EmployeeComponent implements OnInit {

  selectedEmployee: Employee = {id: 20, firstName: "20", lastName: "20", role: "Seniorutvikler"};

  constructor() { }

  ngOnInit(): void {
  }

  changed(employee: Employee) {
      console.log("CHANGED");
      console.log(employee);
      this.selectedEmployee = employee;
  }

}
