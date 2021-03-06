import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '../location';
import { ShruiseService } from '../shruise.service';
@Component({
  selector: 'app-addlocation',
  templateUrl: './addlocation.component.html',
  styleUrls: ['./addlocation.component.css']
})
export class AddlocationComponent implements OnInit {

  location = new Location;
 
  constructor(private _shruiseService: ShruiseService, private router: Router, private activatedRoute: ActivatedRoute ){ }
 ngOnInit(){
    const locId = this.activatedRoute.snapshot.paramMap.get('locId');
   this.location.locId = locId;
    this.location.locName = this.activatedRoute.snapshot.paramMap.get('locName');
 }
 addLocation() {
  console.log('location called');
  if(this.location.locId === null)
{
   this._shruiseService.addLocation(this.location).subscribe(
     
    data => {
      this.router.navigate(['/Location']);
    },
    error => {
      alert(error);
    });
}
else{
  console.log('update');
  this._shruiseService.updateLocation(this.location).subscribe(
    data => {
      this.router.navigate(['/Location']);
    },
    error => {
      alert(error);
    });
}



 }

}
