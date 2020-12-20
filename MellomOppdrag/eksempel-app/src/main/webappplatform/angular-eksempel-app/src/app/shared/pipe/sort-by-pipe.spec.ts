import { SortByPipe } from './sort-by-pipe';

describe('SortByPipe', () => {
  let pipe; //sytem under test

  beforeEach(() => {
    pipe = new SortByPipe();
  })

  it('should create an instance', () => {
    // arrange

    // act
    
    // assert
    expect(pipe).toBeTruthy();
  });

  describe('transform', () => {
    let value: any[];
    let caseInsensitive: boolean;
    let order: string;
    let column: string = ''
  
  
    beforeEach(() => {
      value = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        }
      ];
      column = 'firstName';
      order = 'asc';
      caseInsensitive = true;
      
    })
  
    it('should display same object for firstName for column asc for order and false for caseInsensitive', () => {
      
      // arrange
      let expected = [
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        },
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        }
      ];
      
      // act
      let result: any[] = pipe.transform(value, caseInsensitive, order, column);
      console.log("******result transform");
      console.log(result);
  
      // assert
      expect(result).toEqual(expected);
  
    });


    it('should display a new object for firstName for column desc for order and true for caseInsensitive', () => {
      
      // arrange
      caseInsensitive = true;
      order = 'desc';
      let expected = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        }
      ];
      
      // act
      let result: any[] = pipe.transform(value, caseInsensitive, order, column);
      console.log("********************result transform");
      console.log(result);
  
      // assert
      expect(result).toEqual(expected);
  
    });

  });

  describe('sortOnCaseSensitivity', () => {
    
    let value: any[];
    let caseInsensitive: boolean;
    
    beforeEach(() => {
      value = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        }
      ];
      caseInsensitive = false;
    });

    it('should return same object with caseInsensitive false', () => {
      // arrange
      let expected = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        }
      ];
      
      // act
      let result = pipe.sortOnCaseSensitivity(value, caseInsensitive);

      // assert
      expect(result).toEqual(expected);
    });

    it('should return same object with caseInsensitive true', () => {
      // arrange
      caseInsensitive = true;

      let expected = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        }
      ];
      
      // act
      let result = pipe.sortOnCaseSensitivity(value, caseInsensitive);

      // assert
      expect(result).toEqual(expected);
    });

  });


  describe('convertMultiOnCaseSensitivity', () => {
    
    let value: any[];
    let caseInsensitive: boolean;
    let column: string = ''
  
  
    beforeEach(() => {
      value = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        }
      ];
      column = 'firstName';
      caseInsensitive = false;
    })
  
    it('should retur same object with firstName for column and false for caseInsensitive',  () => {
      // arrange
      let expected = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler"
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder"
        }
      ];
    
      // act
      let converted = pipe.convertMultiOnCaseSensitivity(value, column, caseInsensitive);

      // assert
      expect(converted).toEqual(expected);
    });

    it('should retur a new  object with firstName for column and true for caseInsensitive',  () => {
      // arrange
      caseInsensitive = true;

      let expected = [
        {
          "id": 10,
          "firstName":"PEDRO",
          "lastName":"Tiago",
          "role":"Seniorutvikler",
          sortCol: 'pedro'
        },
        {
          "id": 11,
          "firstName":"ANDRE",
          "lastName":"Alexandre",
          "role":"Leder",
          sortCol: 'andre'
        }
      ];
    
      // act
      let result: any[] = pipe.convertMultiOnCaseSensitivity(value, column, caseInsensitive);
      console.log("result");
      console.log(result);

      // assert
      expect(result).toEqual(expected);
    });
  
  });

});
