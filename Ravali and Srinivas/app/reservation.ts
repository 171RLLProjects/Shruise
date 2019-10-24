import { UserProfile } from "./user-profile";
import { Ship } from "./ship";
import { Passenger } from "./passenger";

export class Reservation {
    bookingId : string;
    user : UserProfile;
    totalFare: number;
    ship: Ship;
    noOfSeats:number;
    //passenger:Passenger[];
    cardNo:string;
    pin:number;
    status:string;
}
