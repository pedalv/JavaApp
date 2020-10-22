import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../../domain/employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.less'],
  providers: [ EmployeeService ]
})
export class EmployeeListComponent implements OnInit {

  employees : Employee[] = [];

  showError: boolean = false;
  msgShowError: string = 'Feil! Rest tjene er ned! Inge vis ansatt!';

  selectedEmployee : Employee;

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
    this.allEmployees();
  }

  allEmployees(): void {
    this.service.allEmployees()
      .subscribe(
        data => {
          console.log(data);
          this.employees = data;
        },
        error => {
          this.showError = true;
          console.log(error);
        }
    );
  }

  deleteEmployee(employee : Employee) : void {
    this.service.deleteEmployee(employee.id)
          .subscribe(
              (data : Employee) => {
                console.log(data);
                this.allEmployees();
              },
              error => {
                //this.createError = true;
                console.log(error);
              }
          );
  }

  public selectEmployee(e : Employee) : void  {
    console.log("Employee: "+ e);
    this.selectedEmployee = e;
  }




}
