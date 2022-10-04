import { Component, OnInit } from '@angular/core';
import { MenuItem } from "primeng/api";
import { AuthHttpService } from "@api/services/auth-http.service";
import { first } from "rxjs";
import { SecurityService } from "../../../../services/security.service";
import { Role } from "@api/models/enums/Role";

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.scss']
})
export class MainHeaderComponent implements OnInit {

  userMenuItems: MenuItem[] = [];

  constructor(private authHttpService: AuthHttpService,
              private securityService: SecurityService) {
    this.initUserMenuItems();

    // TODO: unsubscribe on destroy
    this.securityService.isAuthenticated$.subscribe(isAuthenticated => {
      this.initUserMenuItems();
    })
  }

  ngOnInit(): void {
  }

  logout() {
    this.authHttpService.logout()
      .pipe(first())
      .subscribe({
        next: () => {
          this.securityService.logout()
        },
        error: error => console.log(error)
      })
  }

  initUserMenuItems() {
    this.userMenuItems = [
      {
        label: 'Login',
        icon: 'fa-solid fa-right-to-bracket',
        routerLink: '/login',
        visible: !this.securityService.isAuthenticated()
      },
      {
        label: 'Admin panel',
        icon: 'fa-solid fa-screwdriver-wrench',
        routerLink: '/admin',
        visible: this.securityService.hasRole(Role.ADMIN)
      },
      {
        label: 'Logout',
        icon: 'fa-solid fa-right-from-bracket',
        command: () => this.logout(),
        visible: this.securityService.isAuthenticated()
      }
    ];
  }

}
