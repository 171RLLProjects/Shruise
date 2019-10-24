import { Component } from '@angular/core';
 
@Component({
  selector: 'app-root',
  template: ` <h1>Welcome to Ship Reservation</h1>,
  
  <div style="padding:15px">
  <ul class="nav nav-tabs">
 <li routerLinkActive="active"><a routerLink='home'>Home</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='schedule'>Schedule</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='updateSchedule'>Update Schedule</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='addSchedule'>Add Schedule</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='addReservation'>Add Reservation</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='reservations'>Reservations</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='addPassenger'>Add Passengers</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='passengers'>Passengers</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 </ul>
 <br/><br/>
 
 <router-outlet></router-outlet>
 
 </div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Shruise';
}