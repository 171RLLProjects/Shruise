import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ShruiseService } from './shruise.service';
import { FormsModule} from '@angular/forms'
import {Routes,RouterModule} from '@angular/router';
import { ReactiveFormsModule} from '@angular/forms'
import { AddScheduleComponent } from './add-schedule/add-schedule.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { PassengersComponent } from './passengers/passengers.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { AddReservationComponent } from './add-reservation/add-reservation.component';

const appRoute: Routes=[
  {path: 'home',  component: AppComponent},
  {path: 'addSchedule', component: AddScheduleComponent},
  {path: 'updateSchedule', component: AddScheduleComponent},
  {path: 'schedule', component: ScheduleComponent },
  {path: 'addReservation', component: AddReservationComponent},
  {path: 'reservations', component: ReservationsComponent},
  {path: 'addPassenger', component: AddPassengerComponent},
  {path: 'passengers', component: PassengersComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  declarations: [
    AppComponent,
    AddScheduleComponent,
    ScheduleComponent,
    AddPassengerComponent,
    PassengersComponent,
    ReservationsComponent,
    AddReservationComponent,
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule,RouterModule.forRoot(appRoute)
  ],
  providers: [ShruiseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
