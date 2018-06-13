

import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable'
@Injectable()
export class LoginService {  
  constructor(private http: Http) { }
  login(model) {
    console.log("service method"+model);
    let loginUrl = "http://localhost:8080/user/login";
    let headers1 = new Headers({ 'Content-type': 'application/json' });
    return this.http.post(loginUrl, model, { headers: headers1 })
   
  }
}