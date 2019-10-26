import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ShruiseService } from './shruise.service';
import { FormsModule} from '@angular/forms'
import {Routes,RouterModule} from '@angular/router';
import { ReactiveFormsModule} from '@angular/forms'
import { ScheduleComponent } from './schedule/schedule.component';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { PassengersComponent } from './passengers/passengers.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { AddReservationComponent } from './add-reservation/add-reservation.component';
import { RegisterComponent } from './register/register.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { LoginComponent } from './login/login.component';
import { AddShipComponent } from './addship/addship.component';
import { ShiplistComponent } from './shiplist/shiplist.component';
import { HomeComponent } from './home/home.component';
import { LocationComponent } from './location/location.component';
import { RouteComponent } from './route/route.component';
import { ShipComponent } from './ship/ship.component';
import { AddlocationComponent } from './addlocation/addlocation.component';
import { AddrouteComponent } from './addroute/addroute.component';
import { AddscheduleComponent } from './addschedule/addschedule.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TicketComponent } from './ticket/ticket.component';
import { BookingComponent } from './booking/booking.component';

const appRoute: Routes=[
  {path: 'home',  component: HomeComponent},
  {path:'login', component:LoginComponent}, 
  {path: 'register',  component:RegisterComponent},
  {path: 'adminHome', component : AdminhomeComponent , children : [
    {path:'addLocation',component:AddlocationComponent},
    {path:'addRoute',component:AddrouteComponent},
    {path: 'addSchedule', component:AddscheduleComponent},
    {path:'addShip', component:AddShipComponent},
    {path:'userdetails', component:UserdetailsComponent},
   
  {path: 'Location', component: LocationComponent},
  {path: 'Route', component:RouteComponent},
  {path: 'Schedule', component:ScheduleComponent},
  {path: 'Ship', component:ShipComponent},
  {path: 'passengers', component: PassengersComponent },
  {path: 'updateSchedule', component: AddscheduleComponent},
  {path: 'reservations', component: ReservationsComponent}
  ]},
  {path:'customerHome', component: CustomerhomeComponent, children :[
    {path: 'addReservation', component: AddReservationComponent},
 // {path: 'reservations', component: ReservationsComponent},
  {path: 'addPassenger', component: AddPassengerComponent},
  {path:'shiplist', component:ShiplistComponent},
  // {path: 'Location', component: LocationComponent},
 // {path: 'Route', component:RouteComponent},
  //{path: 'Schedule', component:ScheduleComponent},
  //{path: 'Ship', component:ShipComponent},
  {path: 'register',  component:RegisterComponent},
  {path:'login', component:LoginComponent}, 
  {path:'booking', component:BookingComponent}, 
  {path:'ticket', component:TicketComponent}, 
  ]},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**' , component: PagenotfoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AddPassengerComponent,
    PassengersComponent,
    ReservationsComponent,
    AddReservationComponent,
    RegisterComponent,
    UserdetailsComponent,
    LoginComponent,
    AddShipComponent,
    ShiplistComponent,
    HomeComponent,
    LocationComponent,
    RouteComponent,
    ShipComponent,
    AddlocationComponent,
    AddrouteComponent,
    ScheduleComponent,
    AddscheduleComponent,
    HeaderComponent,
    FooterComponent,
    AdminhomeComponent,
  CustomerhomeComponent,
PagenotfoundComponent,
TicketComponent,BookingComponent
 ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule,RouterModule.forRoot(appRoute)
  ],
  providers: [ShruiseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
