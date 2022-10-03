import { Component, OnInit } from '@angular/core';
import { MenuItem } from "primeng/api";
import { AuthHttpService } from "@api/services/auth-http.service";
import { first } from "rxjs";

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.scss']
})
export class MainHeaderComponent implements OnInit {

  userMenuItems: MenuItem[] = [
    {
      label: 'Login',
      icon: 'fa-solid fa-right-to-bracket',
      routerLink: '/login'
    },
    {
      label: 'Admin panel',
      icon: 'fa-solid fa-screwdriver-wrench',
      routerLink: '/admin'
    },
    {
      label: 'Logout',
      icon: 'fa-solid fa-right-from-bracket',
      command: () => this.logout()
    }
  ];

  constructor(private authHttpService: AuthHttpService) {
  }

  ngOnInit(): void {
  }

  logout() {
    this.authHttpService.logout()
      .pipe(first())
      .subscribe({
        next: () => console.log("Logged out"),
        error: error => console.log(error)
      })
  }

}
