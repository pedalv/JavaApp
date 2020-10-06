import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
})
export class EmployeeComponent implements OnInit {

  employees = [
    {id: 1, name: "E 001", description: "E 001 des", email: "e001@email.com"},
    {id: 2, name: "E 002", description: "E 002 des", email: "e002@email.com"},
    {id: 3, name: "E 003", description: "E 003 des", email: "e003@email.com"},
    {id: 4, name: "E 004", description: "E 004 des", email: "e004@email.com"}
  ];
  selectedEmployee;

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
    this.allEmployees();
  }

  allEmployees(){

      this.service.allEmployees()
        .subscribe(
          data => {
            console.log(data);
            //employees = data;
          },
          error => {
            console.log(error);
            console.error("Feil! Hent all ansatte!");
          }
      );
    }





  public createEmployee(e: {id, name, description, email}){
    console.log("Employee created: ", e);

    this.employees.push(e);
  }

  public selectEmployee(e){
    this.selectedEmployee = e;
  }

}
