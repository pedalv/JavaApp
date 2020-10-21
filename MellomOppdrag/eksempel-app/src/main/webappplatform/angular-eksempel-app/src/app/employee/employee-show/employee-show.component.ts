import { Component, Input, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../../domain/employee';
import $ from "jquery";

@Component({
  selector: 'app-employee-show',
  templateUrl: './employee-show.component.html',
  styleUrls: ['./employee-show.component.less'],
  providers: [ EmployeeService ]
})
export class EmployeeShowComponent implements OnInit {

  employee : Employee = {id: null, firstName: "", lastName: "", role: ""};

  rolles = [
     {id: 1, name: "Seniorutvikler"},
     {id: 2, name: "Leader"},
     {id: 3, name: "Administrasjon"}
  ];

  showForm: boolean = false;
  isEdit: boolean = false;
  msgEdit: string = 'Okay! Ansatt oppdatert';

  editError: boolean = false;
  msgEditError: string = 'Feil! Rest tjene er ned! Inge oppdatert ansatt!';

  @Input() selectedEmployee: Employee;

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
  }


 replaceEmployee(employee: Employee) : void {
    console.log("Employee updated: ", employee);

    //save
    this.service.replaceEmployee(employee)
      .subscribe(
          () => {
            this.isEdit = true;
            this.showForm = false;

            setTimeout (() => {
               console.log("Hello from setTimeout");
               this.isEdit = false;
            }, 1000);

          },
          error => {
            this.editError = true;
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

      this.showForm = true;
      this.selectedEmployee = null;
      this.employee = employee;

    }

}
