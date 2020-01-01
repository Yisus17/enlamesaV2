import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SesionService {

  constructor() { }

  loginFunction(user){
    if(user.username =="jesus" && user.password=="jesus"){
      console.log(user);
    }
  }

}
