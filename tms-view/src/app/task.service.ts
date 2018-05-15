import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {TaskApi} from "./page";
import {environment} from "../environments/environment";

const baseApiUrl = environment.baseApiUrl;


@Injectable()
export class TaskService {
  public TASK_API = baseApiUrl + 'tasks';

  constructor(private http: HttpClient) {}

  getTasks(sort: string, order: string, page: number): Observable<TaskApi> {
    const href = this.TASK_API;
    const requestUrl = `${href}?sort=${sort}&order=${order}&page=${page + 1}`;
    return this.http.get<TaskApi>(requestUrl);
  }

  get(id: string) {
    return this.http.get(this.TASK_API + '/' + id);
  }

  remove(id: string) {
    return this.http.delete(this.TASK_API + "/" + id);
  }

  update(id: string, task: any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.put(this.TASK_API + "/" + id, task);
    return result;
  }


}
