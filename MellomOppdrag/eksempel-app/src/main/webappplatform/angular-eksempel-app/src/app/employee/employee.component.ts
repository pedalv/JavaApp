import { Component, OnInit } from '@angular/core';
import { Employee } from '../domain/employee';
import { CloneService } from '../core/service/clone.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
})

export class EmployeeComponent implements OnInit {

  selectedEmployee: Employee;

  constructor(private cloneService: CloneService) { }

  ngOnInit(): void {
  }

  changed(employee: Employee) {
      console.log("CHANGED-clone");
      console.log(employee);
      //this.selectedEmployee = employee;
      //this.selectedEmployee = JSON.parse(JSON.stringify(employee)); //Clone ref
      this.selectedEmployee = this.cloneService.deepClone<Employee>(employee); //Clone ref

      console.log(JSON.parse(JSON.stringify(employee)));
      console.log(this.cloneService.deepClone<Employee>(employee));

  }

}
