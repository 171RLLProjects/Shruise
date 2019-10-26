import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import { Router } from '@angular/router';
import { ShruiseService } from '../shruise.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  schedule :Schedule[]
  constructor(private _shruiseService: ShruiseService, private _router: Router) { }
  ngOnInit() {
    console.log('Schedule');
    this._shruiseService.getSchedule().subscribe(schedule => {
      this.schedule = schedule;
    });
  }
  delete(sch: Schedule): void {
    console.log('delete');
    this._shruiseService.deleteSchedule(sch.scheduleId).subscribe( data => {
     
      this.schedule = this.schedule.filter(u => u !== sch);
    });
  }
  edit(sch: Schedule): void{
    console.log('edit called');
    this._router.navigate(['/adminHome/addSchedule', sch]);
  }

}
