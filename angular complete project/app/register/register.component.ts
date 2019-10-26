import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { ShruiseService } from '../shruise.service';
import { UserProfile } from '../user-profile';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {
  userprofile = new UserProfile;
  
  constructor(private _shruiceService : ShruiseService,private _router :Router,private activatedRoute: ActivatedRoute) { }

   ngOnInit() {
   //const userId = this.activatedRoute.snapshot.paramMap.get('userId');
    
  }
  register() {
   
    this.userprofile = {
      "userId": "",
      "userName": this.userprofile.userName,
      "pass":  this.userprofile.pass,
      "gender": this.userprofile.gender,
      "role": "",
      "phoneNo": this.userprofile.phoneNo,
      "address": this.userprofile.address,
      "age": this.userprofile.age
    };
  console.log('add user called'+this.userprofile);
    // (this.userprofile.userId === null) {
      this._shruiceService.register(this.userprofile).subscribe(

        data => {
    
          this._router.navigate(['/login']);
        },
        error => {
          alert(error);
        });
   // }
    
  }
}

