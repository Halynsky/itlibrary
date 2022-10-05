import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SecurityService } from "@services/security.service";

@Injectable({providedIn: "root"})
export class NotAuthenticatedGuard implements CanActivate {

  constructor(private securityService: SecurityService,
              private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.securityService.isAuthenticated() ? this.router.createUrlTree(['/']) : true
  }

}

