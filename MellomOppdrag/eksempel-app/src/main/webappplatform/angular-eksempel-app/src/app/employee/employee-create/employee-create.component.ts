import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../../domain/employee';
import { BaseEmployeeComponent } from '../base-employee/base-employee.component'

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.less'],
  providers: [ EmployeeService ]
})
export class EmployeeCreateComponent extends BaseEmployeeComponent implements OnInit {

  employee : Employee = {id: null, firstName: "", lastName: "", role: ""};

  createError: boolean = false;
  msgCreateError: string = 'Feil! Rest tjene er ned! Inge ny ansatt!';

  isCreate: boolean = false;
  msgCreated: string = 'Employee created';
/*
  rolles = [
   {id: 1, name: "Seniorutvikler"},
   {id: 2, name: "Leader"},
   {id: 3, name: "Administrasjon"}
  ];
*/
  //GET http://localhost:4200/api/employee/all 504 (Gateway Timeout)

  constructor(private service: EmployeeService) {
    super();
  }

  ngOnInit(): void {
  }

  createEmployee(employee: Employee) : void {
      console.log("Employee created: ", employee);

      //TODO: Validate

      //save
      this.service.createEmployee(employee)
        .subscribe(
            (data : Employee) => {
              console.log(data);
              this.isCreate = true;
              this.createError = false;
              this.employee = {id: null, firstName: "", lastName: "", role: ""};

              //fetch
              //this.allEmployees();

              //this.employees.push(data);
            },
            error => {
              this.createError = true;
              this.isCreate = false;
              console.log(error);
            }
        );
    }



}
