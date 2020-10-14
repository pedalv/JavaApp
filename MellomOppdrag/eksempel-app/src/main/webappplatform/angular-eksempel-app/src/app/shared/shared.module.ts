import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgpSortModule } from "ngp-sort-pipe";
import { SortDirective } from './directive/sort.directive';
//import { SortByPipe } from "./pipe/sort-by-pipe"; // SortByPipe === SortDirective

@NgModule({
  declarations: [
    SortDirective, //SortByPipe

  ],
  imports: [
    CommonModule,
  ],
  exports: [
    CommonModule,
    FormsModule,
    NgpSortModule,
    SortDirective, //SortByPipe
  ]
})
export class SharedModule { }

/*
--


import { FilterTextboxModule } from './filter-textbox/filter-textbox.module';
import { PaginationModule } from './pagination/pagination.module';

import { CapitalizePipe } from './pipes/capitalize.pipe';
import { TrimPipe } from './pipes/trim.pipe';
import { SortByDirective } from './directives/sortby.directive';

@NgModule({
  imports: [CommonModule, FilterTextboxModule, PaginationModule ],
  exports: [ CommonModule, FormsModule, CapitalizePipe, TrimPipe, SortByDirective, FilterTextboxModule, PaginationModule ],
  declarations: [ CapitalizePipe, TrimPipe, SortByDirective ]
})
*/
