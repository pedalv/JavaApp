// INTERFACE only for fields
// CLASS for fields Get Set Methods ...

export class Employee {
  id: number;
  firstName: string;
  lastName: string;
  role: string;

  /** Create a default new Employee, merging in properties of the optional employee argument */
  static create(id: number, firstName: string, lastName: string, role: string) {
    const newEmployee = Object.assign(new Employee(), {
      // Defaults
      id,
      firstName,
      lastName,
      role,
    });
    return newEmployee;
  }

}
