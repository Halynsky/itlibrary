import { RouterModule, Routes } from "@angular/router";
import { MainLayoutComponent } from "@modules/main/layout/main-layout.component";
import { NotAuthenticatedGuard } from "@guards/not-authenticated.guard";

const routes: Routes = [
  { path: "",
    component: MainLayoutComponent,
    children: [
      { path: "", loadChildren: () => import('./components/shop/shop.component').then(m => m.ShopModule) },
      { path: "login", loadChildren: () => import('./components/login/login.component').then(m => m.LoginModule), canActivate: [NotAuthenticatedGuard] },
    ]
  }
]

export const routing = RouterModule.forChild(routes)
