import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { API_URL } from "@config/Constants";
import { Book } from "@api/models/Book";
import { RestPage } from "@api/models/RestPage";
import { Pagination } from "@api/models/Pagination";


@Injectable({providedIn: 'root'})
export class BookHttpService {
  private readonly URL = `${API_URL}/books`;

  constructor(private http: HttpClient) {
  }

  get(id: number) {
    return this.http.get<Book>(`${this.URL}/${id}`)
  }

  getAll(params: {[key: string]: any}, pagination: Pagination) {
    params = new HttpParams({ fromObject: {...params, ...pagination} })
    return this.http.get<RestPage<Book>>(this.URL, { params })
  }

}
