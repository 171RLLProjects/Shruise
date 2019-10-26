import { Component, OnInit } from '@angular/core';
import { Reservation } from '../reservation';
import { Passenger } from '../passenger';
import { ShruiseService } from '../shruise.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-passenger',
  templateUrl: './add-passenger.component.html',
  styleUrls: ['./add-passenger.component.css']
})
export class AddPassengerComponent implements OnInit {
reservations:Reservation[];
bookingId:string;
passenger=new Passenger;
userId:string;
shipId:string;
scheduleId:string;
routeId:string;
locId:string;
  constructor(private _passengerService:ShruiseService,private _router:Router,private _activatedRoute:ActivatedRoute){}
  ngOnInit(){
    this._passengerService.getBooking().subscribe(book=>{
      this.reservations=book;
    },
    error =>{
      alert(error);
    });
    this.passenger.passengerId=this._activatedRoute.snapshot.paramMap.get('passengerId');
if(this.passenger.passengerId!==null){
  this._passengerService.getPassengerById(this.passenger.passengerId).subscribe(passengers=>{
    this.passenger=passengers;
    this.bookingId=this.passenger.reservation.bookingId;
}
  )
  }
}

addPassenger(){
  this.passenger={
    'passengerId':this.passenger.passengerId,
    'passengerName':this.passenger.passengerName,
    'gender':this.passenger.gender,
    'age':this.passenger.age,
    'aadharNumber':this.passenger.aadharNumber,
    'seatNo':this.passenger.seatNo,
    'journeyDate':this.passenger.journeyDate,
    'reservation':{
      'bookingId':this.bookingId,
      'totalFare':122,
    'noOfSeats':1,
    'cardNo':'1111',
    'pin':12,
    'status':'hi',
    'ship':{
      'shipId': this.shipId,
      'shipName' : 'ravali',
      'seatingCapacity' : 1,
      'wListCapacity' : 11,
      'reserveCapacity' : 5,
      'route': {
        'routeId': this.routeId,
        'distance': 56,
        'duration':'57',
        'costPerkm':70,
        'source':
      {
        'locId': this.locId,
        'locName': 'testing'
      },
     'destination':{
        'locId': this.locId,
        'locName': 'testing'
      },
      },
      'schedule':
    {
      'scheduleId': this.scheduleId,
      'startDate': 'gjkg',
      'endDate':'hfff'
    },
    },
    'user':{
      'userId':this.userId,
      'userName':'RAVALI',
      'pass':'fgjf',
      'gender':'fhfja',
      'role':'gdfs',
      'phoneNo':31424234,
      'address':'gkjfhilugadifj',
      'age':11
    }
    }
  }
  this._passengerService.addPassenger(this.passenger).subscribe(
    data => {
     
      this._router.navigate(['/customerHome/booking']);
    },
    error => {
      alert(error);
    });
}
}
