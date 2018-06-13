
import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable'
@Injectable()
export class TaskLogService {  
  constructor(private http: Http) { }
  saveTasklog(model) {
    console.log("service method"+model);
    let saveurl = "http://localhost:8080/task/save";
    let headers1 = new Headers({ 'Content-type': 'application/json' });
    return this.http.post(saveurl,model,{headers:headers1})
   
  }
  getAll() {
    console.log("service method");
    let geturl = "http://localhost:8080/task/list";
    let headers1 = new Headers({ 'Content-type': 'application/json' });
    return this.http.get(geturl,{headers:headers1});
   
  }
  getById(id) {
    console.log("service method");
    let getUrl = "http://localhost:8080/task/getById/"+id;
    let headers1 = new Headers({ 'Content-type': 'application/json' });
    return this.http.get(getUrl,{headers:headers1});
   
  }
}