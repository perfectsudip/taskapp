
import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable'
@Injectable()
export class UserService {  
  constructor(private http: Http) { }
  getById(id) {
    console.log("service method"+id);
    let getByIdUrl = "http://localhost:8080/user/"+id;
    let headers1 = new Headers({ 'Content-type': 'application/json' });
    return this.http.get(getByIdUrl,{headers:headers1})
   
  }
}