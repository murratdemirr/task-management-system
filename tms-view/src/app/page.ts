import {Task} from "./task";

export interface TaskApi {
  content: Task[];
  totalElements: number;
}
