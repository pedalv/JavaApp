import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.less']
  //changeDetection: ChangeDetectionStrategy.OnPush
})

export class EmployeeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
