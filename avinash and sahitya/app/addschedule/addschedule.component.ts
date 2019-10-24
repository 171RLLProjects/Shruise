import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import { Router, ActivatedRoute } from '@angular/router';
import { ShruiseService } from '../shruise.service';

@Component({
  selector: 'app-addschedule',
  templateUrl: './addschedule.component.html',
  styleUrls: ['./addschedule.component.css']
})
export class AddscheduleComponent implements OnInit {
  schedule = new Schedule;
  constructor(private _shruiseService: ShruiseService, private _router: Router, private _activatedRoute: ActivatedRoute ){ }
  ngOnInit() {

    this.schedule.scheduleId = this._activatedRoute.snapshot.paramMap.get('scheduleId');
    this.schedule.startDate = this._activatedRoute.snapshot.paramMap.get('startDate');
    this.schedule.endDate = this._activatedRoute.snapshot.paramMap.get('endDate');
 }

 addSchedule() {
  console.log('schedule called');
  if(this.schedule.scheduleId === null)
  {

  console.log('service called')
   this._shruiseService.addSchedule(this.schedule).subscribe(
     
    data => {
      this._router.navigate(['/Schedule']);
    },
    error => {
      alert(error);
    });
}
 else{
  console.log('update');
  this._shruiseService.updateSchedule(this.schedule).subscribe(
    data => {
      this._router.navigate(['/Schedule']);
    },
    error => {
      alert(error);
    });
}
 }
}