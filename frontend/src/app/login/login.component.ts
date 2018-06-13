import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { LoginService } from '../services/LoginService';
import { User } from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private model = { 'userName': '', 'password': '' };
  user:User=new User();
  constructor(private loginService:LoginService,private router:Router) { }

  ngOnInit() {
  }

  logins(){
    console.log("component method");
    this.loginService.login(this.model).subscribe(data=>{
      this.user=JSON.parse(JSON.parse(JSON.stringify(data))._body);
    
      console.log(this.user.id);
      localStorage.setItem("userid",this.user.id+"");
      this.router.navigateByUrl("/task");

    },error=>{
      JSON.parse(JSON.parse(JSON.stringify(error))._body);
    });
  }
}
