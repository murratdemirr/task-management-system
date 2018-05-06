import { Component } from '@angular/core';

import {TaskService} from "./task.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  time;
  constructor(private taskService : TaskService) {}
  ngOnInit() {
    this.time = this.taskService.whatTimeIsIt();
  }

}
