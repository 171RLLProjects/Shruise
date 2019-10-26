import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Location} from '../location';
import { ShruiseService } from '../shruise.service';
@Component({
  selector: 'app-location',
  templateUrl: './location.component.html'
})
export class LocationComponent implements OnInit {
  location: Location[];
  constructor(private _shruiseService: ShruiseService, private router: Router) { }

  ngOnInit() {
    this._shruiseService.getLocation().subscribe( location => {
      this.location = location;
      console.log(this.location);
    });
  }
delete(loc: Location): void {
  console.log('delete called');
  this._shruiseService.deleteLocation(loc.locId).subscribe( data => {
   
    this.location = this.location.filter(u => u !== loc);
  });
}
edit(loc: Location): void{
  console.log('edit called');
  this.router.navigate(['adminHome/addLocation/', loc]);
}

}
