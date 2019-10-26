import { Component, OnInit } from '@angular/core';
import { ShruiseService } from '../shruise.service';
import { UserProfile } from '../user-profile';



@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html'
})
export class UserdetailsComponent implements OnInit {
users : UserProfile[];
   constructor(private _shruiceService: ShruiseService) { }

  ngOnInit() {    this._shruiceService.getuser().subscribe( userlist =>{
  
    this.users = userlist;
   }); 
  
  }
}
