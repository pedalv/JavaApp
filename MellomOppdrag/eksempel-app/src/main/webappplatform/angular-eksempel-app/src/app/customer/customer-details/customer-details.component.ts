import { Component, OnInit, Input, ChangeDetectionStrategy } from '@angular/core';
import { ICustomer2 } from '../../shared/interfaces';


@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerDetailsComponent implements OnInit {

  @Input() customer: ICustomer2; //Send

  ngOnInit() {}

}
