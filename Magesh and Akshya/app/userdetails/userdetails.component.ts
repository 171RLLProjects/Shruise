import { Component, OnInit } from '@angular/core';
import { Userprofile } from '../userprofile';
import { ShruiceService } from '../shruice.service';


@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {
users : Userprofile[];
   constructor(private _shruiceService: ShruiceService) { }

  ngOnInit() {    this._shruiceService.getuser().subscribe( userlist =>{
  
    this.users = userlist;
   }); 
  
  }
}
