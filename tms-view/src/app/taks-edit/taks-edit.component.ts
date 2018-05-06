import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskService} from "../task.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-taks-edit',
  templateUrl: './taks-edit.component.html',
  styleUrls: ['./taks-edit.component.css']
})
export class TaksEditComponent implements OnInit, OnDestroy {

  task: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private taskService: TaskService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      console.info("id = " + id) ;
      if (id) {
        this.taskService.get(id).subscribe((task: any) => {
          if (task) {
            this.task = task;
            console.info("yeap")
          } else {
            console.log(`Car with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/task']);
  }

  save(id: string, form: NgForm) {
    this.taskService.update(id, form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(id: string) {
    this.taskService.remove(id).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
