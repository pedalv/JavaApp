import { Component, Input, Output, EventEmitter, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../../domain/employee';
import $ from "jquery";
import { ClonerService } from '../../core/services/cloner.service';
import { BaseEmployeeComponent } from '../base-employee/base-employee.component'

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.less'],
  providers: [ EmployeeService ],
  //changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeDetailsComponent extends BaseEmployeeComponent implements OnInit {

  employee : Employee = {id: null, firstName: "", lastName: "", role: ""};
/*
  rolles = [
     {id: 1, name: "Seniorutvikler"},
     {id: 2, name: "Leader"},
     {id: 3, name: "Administrasjon"}
  ];
*/
  showForm: boolean = false;
  isEdit: boolean = false;
  msgEdit: string = 'Okay! Ansatt oppdatert';

  editError: boolean = false;
  msgEditError: string = 'Feil! Rest tjene er ned! Inge oppdatert ansatt!';

  @Input() selectedEmployee: Employee; //Send
  @Output() selectedEmployeeChanged = new EventEmitter<Employee>(); //subscribe

  constructor(private service: EmployeeService,
              private clonerService: ClonerService) {
    super();
  }

  ngOnInit(): void {
     //OKAY on init
     this.selectedEmployee = {id: 20, firstName: "20", lastName: "20", role: "Seniorutvikler"};


     /*
     Child/presentation component should not change data

     Fix: changeDetection
        OnPush causes change detection to run when:
        1. An input property reference changes
        2. An outup property/EventEmitter or DOM event fires
        3. Aync pipe receives an event
        4. Change detection ins manually invoked via ChangeDetectorRef

     OnPush Benefits:
     1. Performance (Componet isn't checked until OnPush condition are met)
     2. Prevent the presentation component from updating state is should get from the container/parent

      when using OnPush detectors, then the framework will check an OnPush component when
      any of its input properties changes, when it fires an event, or when abservable fires an event
     */
     setTimeout (() => {
        this.selectedEmployee = {id: 0, firstName: "PE20", lastName: "AL20", role: "Seniorutvikler"};
     }, 2000);

  }

  //Subscribe
  change(employee) {
      console.log("OUTPUT-CHANGE");
      this.selectedEmployee =  {id: 0, firstName: "Pedro20", lastName: "Alves20", role: "Seniorutvikler"}; //null editEmployee
      if(employee.id!==null) {
        this.selectedEmployee = employee;
      }
      console.log(this.selectedEmployee);
      this.replaceEmployee(this.selectedEmployee);
      this.selectedEmployeeChanged.emit(this.selectedEmployee); //To send an event
  }

 replaceEmployee(employee: Employee) : void {
    console.log("replaceEmployee Employee updated: ");
    console.log(employee);

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
      console.log("edit Employee");
      console.log(employee);

      $("#id").val(employee.id);
      $("#firstName").val(employee.firstName);
      $("#lastName").val(employee.lastName);
      $("#role").val(employee.role);

      this.showForm = true;
      this.selectedEmployee = null;
      //this.employee = employee;
      //this.employee = JSON.parse(JSON.stringify(employee)); //Clone ref
      this.employee = this.clonerService.deepClone<Employee>(employee); //Clone ref
  }

}
