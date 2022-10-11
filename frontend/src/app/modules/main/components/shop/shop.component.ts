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
import { Pagination } from "@api/models/Pagination";


@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit {
  readonly InventoryStatus = InventoryStatus;
  books: RestPage<Book> = new RestPage<Book>();

  sortOptions: SelectItem[] = [
    {label: 'Price High to Low', value: 'price,DESC'},
    {label: 'Price Low to High', value: 'price,ASC'}
  ];

  sortKey: string = this.sortOptions[0].value
  searchTerm: string = '';
  pagination: Pagination = new Pagination()

  constructor(private bookHttpService: BookHttpService) {
  }

  ngOnInit() {
  }

  onLazyLoad(event: any) {
    console.log(event);
    this.pagination = Pagination.fromPrimeNgDataView(event, this.sortKey);
    this.getBooks({searchTerm: this.searchTerm}, Pagination.fromPrimeNgDataView(event, this.sortKey))
  }

  getBooks(filters: {[key: string]: string} = {}, pagination: Pagination = new Pagination(0, 9, this.sortKey)) {
    this.bookHttpService.getAll(filters, pagination).pipe(first())
      .subscribe({
        next: books => this.books = books,
        error: error => console.error(error)
      })
  }

  onSortChange(event: any) {
    this.pagination.sort = event.value
    this.getBooks({searchTerm: this.searchTerm}, this.pagination)
  }

  onSearchTermInput(event: any) {
    this.getBooks({searchTerm: this.searchTerm}, this.pagination)
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
