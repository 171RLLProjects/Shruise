import { Component, OnInit } from '@angular/core';
import { HomeComponent } from '../home/home.component';
import { ShruiceService } from '../shruice.service';
import { Userprofile } from '../userprofile';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  homes   = new Userprofile;


  constructor(private _shruiceService: ShruiceService,private _router: Router) { }

  ngOnInit() { }
  login()
  {
      this._shruiceService.login(this.homes.userId, this.homes.pass).subscribe(
      role=>{
     if(this.homes.role == 'Admin')
     {
      this._router.navigate(['/userdetails']);
     }
     else
      {
      this._router.navigate(['/home']);
     }
      });
    
    }
  }