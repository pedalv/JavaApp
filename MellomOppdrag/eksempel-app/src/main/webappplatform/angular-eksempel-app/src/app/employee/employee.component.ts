import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../domain/employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
})
export class EmployeeComponent implements OnInit {

  employee : Employee = {id: null, firstName: "", lastName: "", role: ""};
  employees : Employee[] = [];
  selectedEmployee : Employee;

  showError: boolean = false;
  createError: boolean = false;
  msgShowError: string = 'Feil! Rest tjene er ned! Inge vis ansatt!';
  //GET http://localhost:4200/api/employee/all 504 (Gateway Timeout)
  msgCreateError: string = 'Feil! Rest tjene er ned! Inge ny ansatt!';


  rolles = [
       {id: 1, name: "Seniorutvikler"},
       {id: 2, name: "Leader"},
       {id: 3, name: "Administrasjon"}
     ];


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

  createEmployee(employee: {id: number, firstName: string, lastName: string, role: string}) : void {
    console.log("Employee created: ", employee);

    //TODO: Validate

    //save
    this.service.createEmployee(employee)
      .subscribe(
          data => {
            console.log(data);
            this.employees.push(data);
          },
          error => {
            this.createError = true;
            console.log(error);
          }
      );
    //fetch
    this.allEmployees();

  }

  public selectEmployee(e : Employee) : void  {
      this.selectedEmployee = e;
    }

}
