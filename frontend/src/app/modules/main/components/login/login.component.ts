import { Component, NgModule, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { AuthHttpService } from "@api/services/auth-http.service";
import { first } from "rxjs";
import { SecurityService } from "../../../../services/security.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  credentials = {
    email: '',
    password: '',
  }

  constructor(private authHttpService: AuthHttpService,
              private securityService: SecurityService) { }

  ngOnInit(): void {
  }

  login() {
    this.authHttpService.login(this.credentials)
      .pipe(first())
      .subscribe({
        next: user => {
          console.log("Logged in", user)
          this.securityService.login(user)
        },
        error: error => console.log(error)
      })
  }

}

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: LoginComponent}]),
    CommonModule,
    FormsModule,
    InputTextModule,
    ButtonModule
  ]
})
export class LoginModule { }
