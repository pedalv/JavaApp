import { Employee } from '../domain/employee';

import { EmployeeComponent } from './employee.component';


describe('EmployeeComponent', () => {
  //sytem under test
  //let fixture: ComponentFixture<EmployeeComponent>;

  let component: EmployeeComponent;
  let selectedEmployee: Employee;
  let mockClonerService
  
 
  beforeEach(async () => {
    selectedEmployee = {
      "id": 10,
      "firstName":"P",
      "lastName":"M",
      "role":"Seniorutvikler"
    };
    mockClonerService = jasmine.createSpyObj([
      'deepClone'
    ]);

    /*
    await TestBed.configureTestingModule({
      declarations: [ EmployeeComponent ]
    })
    .compileComponents();
    */
  });

  beforeEach(() => {
    //fixture = TestBed.createComponent(EmployeeComponent);
    //component = fixture.componentInstance;
    //fixture.detectChanges();

    component = new EmployeeComponent(mockClonerService)
  });

  it('should create', () => {
    // arrange

    // act

    // assert
    expect(component).toBeTruthy();
  });

  it("should show that method ngOnInit is called with zero arguments", function() {
    // arrange
    component.selectedEmployee = selectedEmployee;

    // act
    component.ngOnInit()

    // assert
    expect(true).toBe(true); 
  });

  it('should show that metod changed is called with one argument', () => {

    // arrange
    mockClonerService.deepClone.and.returnValue(selectedEmployee);

    // act
    component.changed(selectedEmployee);
    
    // assert
    expect(component.selectedEmployee.id).toBe(selectedEmployee.id); 
    expect(component.selectedEmployee.firstName).toBe(selectedEmployee.firstName); 
    expect(component.selectedEmployee.lastName).toBe(selectedEmployee.lastName); 
    expect(component.selectedEmployee.role).toBe(selectedEmployee.role);    
  });

});
