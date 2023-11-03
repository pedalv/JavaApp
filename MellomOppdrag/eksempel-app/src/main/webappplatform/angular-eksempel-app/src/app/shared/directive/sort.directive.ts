import { Directive, Input, ElementRef, Renderer2, HostListener } from '@angular/core';
import { Sort } from '../util/sort';

@Directive({
  selector: '[appSort]'
})
export class SortDirective {

  @Input() appSort: Array<any>;

  constructor(
    private renderer: Renderer2,
    private targetElem: ElementRef) { }

  @HostListener("click")
  sortData() : void {
    // Create Object of sort class
    const sort : Sort = new Sort();

    //Get Reference of Current Clicked ElementRef
    const elem = this.targetElem.nativeElement;

    //Get In Which Order list should be sorted by default it sould be set to desc on element attribute
    const order : string = elem.getAttribute("data-order");

    //Get In which Type specially set [data-type-date] if it is date field
    const type : string = elem.getAttribute("data-type");

    //Get The Property Name from Element Attribute
    const property : string  = elem.getAttribute("data-name");


    console.log(
    "click -" +
    "\nsort: " + sort +
    "\nelem: " + elem +
    "\norder: " + order +
    "\ntype: " + type +
    "\nproperty: " + property
    );



    if(order === "desc"){
      this.appSort.sort(sort.startSort(property, order, type));
      elem.setAttribute("data-order", "asc");
    }
    else {
      this.appSort.sort(sort.startSort(property, order, type));
      elem.setAttribute("data-order", "desc");
    }

  }

}
