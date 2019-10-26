import { Reservation } from "./reservation";

export class Passenger {
    passengerId:string;
    passengerName:string;
    gender:string;
    age:number;
    aadharNumber:number;
    seatNo:number;
    journeyDate:Date;
    reservation:Reservation;
}
