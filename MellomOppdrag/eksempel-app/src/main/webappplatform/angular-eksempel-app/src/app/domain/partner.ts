// INTERFACE only for fields
// CLASS for fields Get Set Methods ...

export class Partner {

  id: number;
  name: string;
  description: string;
  email: string;

  /** Create a default new Partner, merging in properties of the optional partner argument */
  static create(id: number, name: string, description: string, email: string) {
    const newEmployee = Object.assign(new Partner(), {
      // Defaults
      id,
      name,
      description,
      email,
    });
    return newEmployee;
  }

}
