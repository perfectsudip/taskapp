import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { TasklogComponent } from './tasklog/tasklog.component';
import { LoginComponent } from './login/login.component';
import { EditTasklogComponent } from './tasklog/edit-tasklog/edit-tasklog.component';

const routes: Routes = [
  { path: 'task', component:TasklogComponent },
  { path: '', component:LoginComponent },
  { path: 'login', component:LoginComponent },
  { path: 'task/edit/:id', component: EditTasklogComponent},
];

@NgModule({
  exports: [ RouterModule ],  
  imports: [ RouterModule.forRoot(routes)]
})
export class AppRoutingModule {}
