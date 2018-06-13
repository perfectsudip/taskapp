import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { Http,HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { TasklogComponent } from './tasklog/tasklog.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './services/LoginService';
import { UserService } from './services/userService';
import { TaskLogService } from './services/TasklogService';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { EditTasklogComponent } from './tasklog/edit-tasklog/edit-tasklog.component';


@NgModule({
  declarations: [
    AppComponent,
    TasklogComponent,
    LoginComponent,
    EditTasklogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    NgxDatatableModule
  ],
  providers: [LoginService,UserService,TaskLogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
