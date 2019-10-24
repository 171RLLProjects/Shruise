import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<h1>{{title}}</h1>
  <div style="padding:15px">
  <ul class="nav nav-tabs">
  <li routerLinkActive="active"><a routerLink='home'>Home</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='Location'>Location</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='addLocation'>AddLocation</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='Route'>Route</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='addRoute'>AddRoute</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='Schedule'>Schedule</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='addSchedule'>AddSchedule</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='Ship'>Ship</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  <li><a routerLink='addShip'>AddShip</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  </ul>
  <br/><br/>
  <router-outlet></router-outlet>
</div>
 ` ,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ShipReservation';
}
