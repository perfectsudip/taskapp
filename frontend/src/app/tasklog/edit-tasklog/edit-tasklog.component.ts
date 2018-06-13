import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskLogService } from '../../services/TasklogService';
import { Router } from '@angular/router';
import { Tasklog } from '../../model/tasklog';

@Component({
  selector: 'app-edit-tasklog',
  templateUrl: './edit-tasklog.component.html',
  styleUrls: ['./edit-tasklog.component.css']
})
export class EditTasklogComponent implements OnInit {
tasklog:Tasklog= new Tasklog();
  constructor(private route: ActivatedRoute, private tasklogService: TaskLogService,
    private router:Router) {
  
      this.route.params.subscribe(
        params => {
          console.log("param "+params.id);
          this.tasklogService.getById(params.id).subscribe(
            data => {
             
              this.tasklog = JSON.parse(JSON.parse(JSON.stringify(data))._body);
              console.log(this.tasklog);
            },error =>{
              console.log("error");
              }
          );
        }
      );
    }

  ngOnInit() {
  }
 update(){
  this.tasklogService.saveTasklog(this.tasklog).subscribe(data=>{
    console.log("data updated sucessful");
  });
 }
}
