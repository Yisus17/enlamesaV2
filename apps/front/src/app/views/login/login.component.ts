import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SesionService } from '../../services/sesion.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent { 

  constructor(public router: Router, public sesionService: SesionService){}

  login(){
    let user = {
      username: "jesus",
      password: "jesus"
    }
    this.sesionService.loginFunction(user)
    this.router.navigate(['/dashboard']);
  }
}
