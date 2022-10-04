import { Injectable } from "@angular/core";
import { SecurityUser } from "@api/models/SecurityUser";
import { Role } from "@api/models/enums/Role";
import { BehaviorSubject, ReplaySubject } from "rxjs";
import { Router } from "@angular/router";

@Injectable({ providedIn: "root" })
export class SecurityService {
  private readonly USER_KEY = "user"

  private _isAuthenticated$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isAuthenticated$ = this._isAuthenticated$.asObservable();

  constructor(private router: Router) {
  }

  login(user: SecurityUser) {
    this.updateUserInLocalStorage(user)
    this._isAuthenticated$.next(true)
    this.router.navigate(["/shop"])
  }

  logout() {
    localStorage.removeItem(this.USER_KEY)
    this._isAuthenticated$.next(false)
    this.router.navigate(["/login"])
  }

  getUser(): SecurityUser {
    const stringUser: string | null = localStorage.getItem(this.USER_KEY)
    return stringUser ? JSON.parse(stringUser) : null
  }

  isAuthenticated() {
    return localStorage.getItem(this.USER_KEY) != null;
  }

  private updateUserInLocalStorage(user: SecurityUser) {
    localStorage.setItem(this.USER_KEY, JSON.stringify(user))
  }

  hasRole(role: Role) {
    return this.getUser()?.role === role;
  }

  hasAnyRole(roles: Array<Role>) {
    return roles.includes(this.getUser().role)
  }

}
