import { Component, OnInit } from '@angular/core';
import { Tasklog } from '../model/tasklog';
import { User } from '../model/user';
import { UserService } from '../services/userService';
import { TaskLogService } from '../services/TasklogService';
import { DatatableComponent } from '@swimlane/ngx-datatable';
import { ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tasklog',
  templateUrl: './tasklog.component.html',
  styleUrls: ['./tasklog.component.css']
})
export class TasklogComponent implements OnInit {
  user:User= new User();
  tasklog:Tasklog= new Tasklog();
  rows:Array<Tasklog>=[];
  taskLogs:Array<Tasklog>;
  columns=[
    
     {prop: 'storyName'},
     {prop: 'projettask'},
     {prop: 'taskDetail'},
     {prop: 'datePoste'},
     {prop: 'hours'},
    
  ];
  @ViewChild(DatatableComponent) table: DatatableComponent;

  constructor(private userService:UserService,
    private routes:Router,private tasklogService:TaskLogService) { }

  ngOnInit() {
   this.getUser();
   this.getAllTask();

  }

  getUser(){
    var id=localStorage.getItem("userid");
    this.userService.getById(id).subscribe(
      data=>{
        this.user=JSON.parse(JSON.parse(JSON.stringify(data))._body);
        this.tasklog.user=this.user;
        console.log(this.user.userName);
      },error =>{
        console.log("error in getbyid");
      }
      );
  }
  addTask(){
   this.tasklogService.saveTasklog(this.tasklog).subscribe(data=>{
     console.log("data inserted sucessful");
   });
  }
getAllTask(){
  this.tasklogService.getAll().subscribe(data=>{
    this.rows=JSON.parse(JSON.parse(JSON.stringify(data))._body);
  });
}
navigate(id){
  console.log(id);
  this.routes.navigateByUrl("task/edit/"+id);


}
}
