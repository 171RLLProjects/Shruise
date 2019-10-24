import { Component, OnInit } from '@angular/core';
import { ShruiseService } from '../shruise.service';
import { Router } from '@angular/router';
import { Schedule } from '../schedule';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
schedule :Schedule[];
  constructor(private _scheduleService: ShruiseService, private _router: Router) { }

  ngOnInit() {
    this._scheduleService.getSchedule().subscribe(schedule => {
      this.schedule = schedule;
    });
  }

  delete(sch: Schedule): void {
    this._scheduleService.deleteSchedule(sch.scheduleId).subscribe( data => {
     
      this.schedule = this.schedule.filter(u => u !== sch);
    });
  }
  
   
  }

