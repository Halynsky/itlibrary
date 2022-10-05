import { Component, NgModule, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { UserHttpService } from "@api/services/user-http.service";
import { finalize, first } from "rxjs";
import { User } from "@api/models/User";
import { TableModule } from "primeng/table";
import { RestPage } from "@api/models/RestPage";
import { Pagination } from "@api/models/Pagination";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  users: RestPage<User> = new RestPage<User>();
  loading: boolean = false;

  constructor(private userHttpService: UserHttpService) {
  }

  ngOnInit(): void {
  }

  onLazyLoad(event: any) {
    console.log(event)
    console.log(Pagination.fromPrimeNg(event))

    this.loadData(Pagination.fromPrimeNg(event))
  }

  loadData(pagination: Pagination = new Pagination()) {
    this.loading = true;
    this.userHttpService.getAll(pagination)
      .pipe(first(), finalize(() => this.loading = false))
      .subscribe({
        next: users => this.users = users,
        error: error => console.error(error)
      })
  }

}

@NgModule({
  declarations: [
    UsersComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: UsersComponent}]),
    CommonModule,
    TableModule
  ]
})
export class UsersModule { }
