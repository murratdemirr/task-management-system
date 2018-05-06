import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {
  MatInputModule,
  MatProgressSpinnerModule,
  MatPaginatorModule, MatTableModule, MatSortModule, MatToolbarModule
} from "@angular/material";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppComponent} from './app.component';
import {TaskService} from "./task.service";
import {TaskComponent} from './task/task.component';
import {HttpClientModule} from "@angular/common/http";
import { TaksEditComponent } from './taks-edit/taks-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    TaksEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatToolbarModule
  ],
  providers: [TaskService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
