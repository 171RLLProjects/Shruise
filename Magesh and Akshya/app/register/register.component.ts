import { Component, OnInit } from '@angular/core';
import { Userprofile } from '../userprofile';
import { ShruiceService } from '../shruice.service';
import { Router, ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userprofile = new Userprofile;
  
  constructor(private _shruiceService : ShruiceService,private _router :Router,private activatedRoute: ActivatedRoute) { }

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
    
          this._router.navigate(['/userdetails']);
        },
        error => {
          alert(error);
        });
   // }
    
  }
}

