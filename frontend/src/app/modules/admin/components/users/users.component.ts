import { Component, NgModule, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { UserHttpService } from "@api/services/user-http.service";
import { finalize, first } from "rxjs";
import { User } from "@api/models/User";
import { TableModule } from "primeng/table";
import { RestPage } from "@api/models/RestPage";
import { Pagination } from "@api/models/Pagination";
import { PrimeNgUtil } from "@api/utils/PrimeNgUtil";
import { YesNoPipeModule } from "@pipes/yes-no-pipe/yes-no.pipe";
import { MultiSelectModule } from "primeng/multiselect";
import { FormsModule } from "@angular/forms";
import { DropdownModule } from "primeng/dropdown";
import { SelectItem } from "primeng/api";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  users: RestPage<User> = new RestPage<User>();
  loading: boolean = false;

  isTrueOptions: SelectItem[] = [
    {label: 'All', value: undefined},
    {label: 'Yes', value: true},
    {label: 'No', value: false},
  ]

  constructor(private userHttpService: UserHttpService) {
  }

  ngOnInit(): void {
  }

  onLazyLoad(event: any) {
    this.loadData(PrimeNgUtil.ngPrimeTableFiltersToParams(event.filters), Pagination.fromPrimeNg(event))
  }

  loadData(filters: {[key: string]: string} = {}, pagination: Pagination = new Pagination()) {
    this.loading = true;
    this.userHttpService.getAll(filters, pagination)
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
    TableModule,
    YesNoPipeModule.forRoot(),
    MultiSelectModule,
    FormsModule,
    DropdownModule,
  ]
})
export class UsersModule { }
