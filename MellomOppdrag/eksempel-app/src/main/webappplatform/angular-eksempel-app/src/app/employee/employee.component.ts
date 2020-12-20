import { Component, OnInit } from '@angular/core';
import { Employee } from '../domain/employee';
import { ClonerService } from '../core/services/cloner.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
})

export class EmployeeComponent implements OnInit {

  selectedEmployee: Employee;

  constructor(private clonerService: ClonerService) { }

  ngOnInit(): void {
  }

  changed(employee: Employee) {
      console.log("CHANGED-cloner");
      console.log(employee);
      //this.selectedEmployee = employee;
      //this.selectedEmployee = JSON.parse(JSON.stringify(employee)); //Clone ref
      this.selectedEmployee = this.clonerService.deepClone<Employee>(employee); //Clone ref

      console.log("this.selectedEmployee");
      console.log(this.selectedEmployee);

      console.log(JSON.parse(JSON.stringify(employee)));
      console.log(this.clonerService.deepClone<Employee>(employee));

  }

}
