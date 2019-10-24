
import { Route } from "./route";
import { Schedule } from "./schedule";
export class Ship {
    shipId:string;
    shipName:string;
    route: Route;
    schedule:Schedule;
    seatingCapacity:number;
    reserveCapacity:number;
    wListCapacity:number;
}
