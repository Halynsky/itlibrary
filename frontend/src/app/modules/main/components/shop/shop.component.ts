import { Component, NgModule, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { Book } from "@api/models/Book";
import { SelectItem } from "primeng/api";
import { FormsModule } from "@angular/forms";
import { DataViewModule } from "primeng/dataview";
import { DropdownModule } from "primeng/dropdown";
import { RatingModule } from "primeng/rating";
import { ButtonModule } from "primeng/button";
import { BookHttpService } from "@api/services/book-http.service";
import { first } from "rxjs";
import { RestPage } from "@api/models/RestPage";
import { InputTextModule } from "primeng/inputtext";
import { InventoryStatus } from "@api/models/enums/InventoryStatus";
import { UserHttpService } from "@api/services/user-http.service";


@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit {
  readonly InventoryStatus = InventoryStatus;
  books: RestPage<Book> = new RestPage<Book>();

  sortOptions: SelectItem[] = [
    {label: 'Price High to Low', value: '!price'},
    {label: 'Price Low to High', value: 'price'}
  ];

  sortKey: string = this.sortOptions[0].value
  sortField: string = 'id';
  sortOrder: number = 1;

  constructor(private bookHttpService: BookHttpService) {
    this.getBooks();
  }

  ngOnInit() {
  }

  getBooks() {
    this.bookHttpService.getAll().pipe(first())
      .subscribe({
        next: books => this.books = books,
        error: error => console.error(error)
      })
  }

  onSortChange(event: any) {
    let value = event.value;
    console.log(value)
  }

}

@NgModule({
  declarations: [
    ShopComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: ShopComponent}]),
    CommonModule,
    FormsModule,
    DataViewModule,
    DropdownModule,
    RatingModule,
    ButtonModule,
    InputTextModule
  ]
})
export class ShopModule {
}
