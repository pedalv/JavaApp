import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { NgpSortModule } from "ngp-sort-pipe";
import { SortDirective } from './directive/sort.directive';
//import { SortByPipe } from "./pipe/sort-by-pipe"; // SortByPipe === SortDirective

@NgModule({
  imports: [
    CommonModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    NgpSortModule,
    SortDirective //SortByPipe
  ],
  declarations: [
    SortDirective //SortByPipe
  ]
})
export class SharedModule { }
