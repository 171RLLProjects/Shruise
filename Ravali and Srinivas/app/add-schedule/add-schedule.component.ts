import { Component, OnInit } from '@angular/core';
import { ShruiseService } from '../shruise.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Schedule } from '../schedule';
@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class  AddScheduleComponent implements OnInit {
 
  schedule = new Schedule;
 
  constructor(private _scheduleService: ShruiseService, private _router: Router, private _activatedRoute: ActivatedRoute ){ }
 ngOnInit(){
     this.schedule.scheduleId = this._activatedRoute.snapshot.paramMap.get('scheduleId');
    this.schedule.startDate = this._activatedRoute.snapshot.paramMap.get('startDate');
    this.schedule.endDate = this._activatedRoute.snapshot.paramMap.get('endDate');
 }
 addSchedule() {
  console.log('schedule called');
 
   this._scheduleService.addSchedule(this.schedule).subscribe(
     
    data => {
      this._router.navigate(['/schedule']);
    },
    error => {
      alert(error);
    });
 }
 
}