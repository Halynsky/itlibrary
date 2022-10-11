import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { User } from "@api/models/User";
import { API_URL } from "@config/Constants";
import { RestPage } from "@api/models/RestPage";
import { Pagination } from "@api/models/Pagination";


@Injectable({providedIn: 'root'})
export class UserHttpService {
  private readonly URL = `${API_URL}/users`;

  constructor(private http: HttpClient) {
  }

  get(id: number) {
    return this.http.get<User>(`${this.URL}/${id}`)
  }

  getAll(params: {[key: string]: any}, pagination: Pagination) {
    params = new HttpParams({ fromObject: {...params, ...pagination} })
    return this.http.get<RestPage<User>>(this.URL, { params })
  }

  create(user: User) {
    return this.http.post<void>(this.URL, user)
  }

  update(user: User) {
    return this.http.post<void>(`${this.URL}/${user.id}`, user)
  }

}
