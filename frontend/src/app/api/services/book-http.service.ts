import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { API_URL } from "@config/Constants";
import { Book } from "@api/models/Book";
import { RestPage } from "@api/models/RestPage";

@Injectable({providedIn: 'root'})
export class BookHttpService {
  private readonly URL = `${API_URL}/books`;

  constructor(private http: HttpClient) {
  }

  get(id: number) {
    return this.http.get<Book>(`${this.URL}/${id}`)
  }

  getAll() {
    return this.http.get<RestPage<Book>>(this.URL)
  }

}
