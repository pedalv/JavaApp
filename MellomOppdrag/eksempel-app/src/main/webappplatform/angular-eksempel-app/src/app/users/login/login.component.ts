import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {

  hasError : boolean = false;
  hasLogout: boolean = false
  error: string = "Invalid username and password."
  logout: string = "You have been logged out."

  constructor() { }

  ngOnInit(): void {
  }

  signIn() : void {
    console.log("Todo signIn");
    //https://dzone.com/articles/angular-logging-and-log-back

    //_csrf=7f083167-fe48-4946-b14c-f1c3c0a9b568&username=bla&password=bla
    //        07144555-7c61-4b51-9885-3c51caf0f349
    //http://localhost:8080/login?username=bla&password=bla

  }

}
