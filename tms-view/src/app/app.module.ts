import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {
  MatInputModule,
  MatProgressSpinnerModule,
  MatPaginatorModule, MatTableModule, MatSortModule, MatToolbarModule, MatCardModule
} from "@angular/material";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppComponent} from './app.component';
import {TaskService} from "./task.service";
import {TaskComponent} from './task/task.component';
import {HttpClientModule} from "@angular/common/http";
import {TaksEditComponent} from './taks-edit/taks-edit.component';
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";

const appRoutes: Routes = [
  {path: '', redirectTo: '/task', pathMatch: 'full'},
  {
    path: 'task',
    component: TaskComponent
  },
  {
    path: 'taks-edit/:id',
    component: TaksEditComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    TaksEditComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatToolbarModule,
    RouterModule.forRoot(appRoutes),
    MatCardModule
  ],
  providers: [TaskService],
  bootstrap: [AppComponent]
})
export class AppModule {


}
