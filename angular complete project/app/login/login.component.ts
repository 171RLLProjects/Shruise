import { Component, OnInit } from '@angular/core';
import { HomeComponent } from '../home/home.component';

import { Router } from '@angular/router';
import { ShruiseService } from '../shruise.service';
import { UserProfile } from '../user-profile';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  userProfile   = new UserProfile;
  role:string;

  constructor(private _shruiceService: ShruiseService,private _router: Router) { }

  ngOnInit() { }
  login()
  {
       console.log('admin');
      this._shruiceService.login(this.userProfile.userName, this.userProfile.pass).subscribe(
        userProfile=>{  this.userProfile = userProfile ;
        console.log(userProfile.role);
        if(this.userProfile.role === 'admin') {
      this._router.navigate(['/adminHome']);
        }else if(this.userProfile.role === 'customer'){
          this._router.navigate(['customerHome/shiplist']);
        }else{
          this._router.navigate(['/home']);
        }
     },
     error => {
      this._router.navigate(['/home']);
     });
    
  }
  logout(){
    localStorage.removeItem('userName');
    localStorage.removeItem ('pass');
    if(this.userProfile.role === 'customer'){
      
    this._router.navigate(['/customerHome/login']);
    }
    else if(this.userProfile.role === 'admin') {
      this._router.navigate(['/adminHome/home']);
  }

}
}