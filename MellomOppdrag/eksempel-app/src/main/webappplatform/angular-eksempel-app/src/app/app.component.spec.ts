// Http testing module and mocking controller
//import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

// Other imports
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
//import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { AppComponent } from './app.component';
//import { BrowserModule } from '@angular/platform-browser';
//import { FormsModule } from '@angular/forms';

describe('AppComponent', () => {
  //let httpClient: HttpClient;
  //let httpTestingController: HttpTestingController;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        //HttpClientTestingModule,
        //BrowserModule,
        //FormsModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'angular-eksempel-app'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('angular-eksempel-app');
  });

});
