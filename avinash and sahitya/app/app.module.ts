import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LocationComponent } from './location/location.component';
import { RouteComponent } from './route/route.component';

import { ShipComponent } from './ship/ship.component';


import { AddShipComponent } from './addShip/addShip.component';
import { ShruiseService } from './shruise.service';
import { AddlocationComponent } from './addlocation/addlocation.component';
import { AddrouteComponent } from './addroute/addroute.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { AddscheduleComponent } from './addschedule/addschedule.component';



//import { EditLocationComponent } from './edit-location/edit-location.component';
//import { DeleteLocationComponent } from './delete-location/delete-location.component';
//import { EditRouteComponent } from './edit-route/edit-route.component';
//import { DeleteRouteComponent } from './delete-route/delete-route.component';
//import { EditScheduleComponent } from './edit-schedule/edit-schedule.component';
//import { DeleteScheduleComponent } from './delete-schedule/delete-schedule.component';
//import { EditShipComponent } from './edit-ship/edit-ship.component';
//import { DeleteShipComponent } from './delete-ship/delete-ship.component';


const appRoute: Routes =[
  {path: 'home', component: AppComponent},
  {path:'addLocation',component:AddlocationComponent},
  {path: 'Location', component: LocationComponent},
  {path: 'Route', component:RouteComponent},
  {path: 'Schedule', component:ScheduleComponent},
  {path: 'addSchedule', component:AddscheduleComponent},
  {path: 'Ship', component:ShipComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
   {path:'addRoute',component:AddrouteComponent},
   {path:'addShip',component:AddShipComponent}
]


@NgModule({
  declarations: [
    AppComponent,
    LocationComponent,
    RouteComponent,
  
    ShipComponent,
  
  
    AddShipComponent,
    AddlocationComponent,
    AddrouteComponent,
    ScheduleComponent,
    AddscheduleComponent
  
    //EditLocationComponent,
    //DeleteLocationComponent,
    //EditRouteComponent,
    //DeleteRouteComponent,
    //EditScheduleComponent,
    //DeleteScheduleComponent,
    //EditShipComponent,
    //DeleteShipComponent

    
  ],
  
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(appRoute)
  ],
  providers: [ShruiseService],
  bootstrap: [AppComponent]
})
export class AppModule { }