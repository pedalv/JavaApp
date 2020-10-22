import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../../domain/employee';


@Component({
  selector: 'app-employee-list-sort',
  templateUrl: './employee-list-sort.component.html',
  styleUrls: ['./employee-list-sort.component.less'],
  providers: [ EmployeeService ]
})
export class EmployeeListSortComponent implements OnInit {

  employees : Employee[] = [];

  showError: boolean = false;
  msgShowError: string = 'Feil! Rest tjene er ned! Inge vis ansatt!';

  sID: boolean= false;
  sFirst: boolean= false;
  sLast: boolean= false;
  sRoller: boolean  = false;

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
