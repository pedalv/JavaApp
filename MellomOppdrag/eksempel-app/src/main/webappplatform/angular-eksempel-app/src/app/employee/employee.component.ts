import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../domain/employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
})
export class EmployeeComponent implements OnInit {

  employees : Employee[] = [];
  selectedEmployee : Employee;

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
    this.allEmployees();
  }

  allEmployees(){
    this.service.allEmployees()
        .subscribe(
          data => {
            console.log(data);
            this.employees = data;
          },
          error => {
            console.log(error);
          }
      );
    }

  public selectEmployee(e : Employee){
      this.selectedEmployee = e;
    }

  //TODO all update single delete

  public createEmployee(e: {id: number, firstName: string, lastName: string, role: string}){
    console.log("Employee created: ", e);

    this.employees.push(e);
  }

}
