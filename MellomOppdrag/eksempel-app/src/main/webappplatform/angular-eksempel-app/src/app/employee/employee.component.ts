import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from '../domain/employee';
import $ from "jquery";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less'],
  providers: [ EmployeeService ]
  //changeDetection: ChangeDetectionStrategy.OnPush
})

export class EmployeeComponent implements OnInit {

  employee : Employee = {id: null, firstName: "", lastName: "", role: ""};
  employees : Employee[] = [];
  selectedEmployee : Employee;
  sID: boolean= false;
  sFirst: boolean= false;
  sLast: boolean= false;
  sRoller: boolean  = false;

  showError: boolean = false;
  createError: boolean = false;
  isCreate: boolean = true;
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

  clickEvent(felt: string){
      console.log(felt);
      switch(felt) {
         case 'id': {
            this.sID = !this.sID;
            break;
         }
         case 'first': {
            this.sFirst = !this.sFirst;
            break;
         }
         case 'last': {
            this.sLast = !this.sLast;
            break;
         }
         case 'roller': {
           this.sRoller = !this.sRoller;
           break;
         }
      }
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
                this.createError = true;
                console.log(error);
              }
          );
  }

  editEmployee(employee: Employee) : void {
    console.log(employee);

    $("#id").val(employee.id);
    $("#firstName").val(employee.firstName);
    $("#lastName").val(employee.lastName);
    $("#role").val(employee.role);

    this.isCreate = false;
    this.employee = employee;

  }

  replaceEmployee(employee: Employee) : void {
    console.log("Employee updated: ", employee);

    //save
    this.service.replaceEmployee(employee)
      .subscribe(
          () => {
            this.isCreate = true;
            this.employee = {id: null, firstName: "", lastName: "", role: ""};
            //fetch
            this.allEmployees();
          },
          error => {
            this.createError = true;
            console.log(error);
          }
      );


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
            this.employee = {id: null, firstName: "", lastName: "", role: ""};
            //fetch
            this.allEmployees();
            //this.employees.push(data);
          },
          error => {
            this.createError = true;
            console.log(error);
          }
      );
  }

  public selectEmployee(e : Employee) : void  {
      this.selectedEmployee = e;
    }

}
