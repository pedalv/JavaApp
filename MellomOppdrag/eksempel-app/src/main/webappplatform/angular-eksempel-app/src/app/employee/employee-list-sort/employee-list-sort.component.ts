import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../../domain/employee';
import { ClonerService } from '../../core/services/cloner.service';

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


  constructor(private service: EmployeeService,
              private clonerService: ClonerService) { }

  ngOnInit(): void {
    this.allEmployees();
  }

  allEmployees(): void {
    this.service.allEmployees()
      .subscribe(
        data => {
          console.log(data);
          //this.employees = JSON.parse(JSON.stringify(data)); //clone ref
          this.employees = this.clonerService.deepClone<Employee[]>(data); //Clone ref
        },
        error => {
          this.showError = true;
          console.log(error);
        }
    );
  }

  clickEvent(felt: string){
      console.log("clickEvent");
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
      if (employee && employee.id) {
        if (confirm(`Really delete the product: ${employee.firstName} ${employee.lastName}?`)) {

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
      }
    }

  public selectEmployee(employee : Employee) : void  {
    console.log("Employee-clone: "+ employee);
    //this.selectedEmployee = employee;
    //this.selectedEmployee = JSON.parse(JSON.stringify(employee)); // clone ref
    this.selectedEmployee = this.clonerService.deepClone<Employee>(employee); //Clone ref
  }

  changed(employee: Employee) {
    console.log("CHANGED-List-sort-cloner");
    console.log(employee);
    //this.selectedEmployee = employee;
    //this.selectedEmployee = JSON.parse(JSON.stringify(employee)); //Clone ref
    this.selectedEmployee = this.clonerService.deepClone<Employee>(employee); //Clone ref
    //console.log(JSON.parse(JSON.stringify(employee)));
    //console.log(this.clonerService.deepClone<Employee>(employee));
    this.allEmployees();
  }

}
