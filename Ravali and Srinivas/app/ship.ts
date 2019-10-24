import { Route } from "./route";
import { Schedule } from "./schedule";

export class Ship {
    shipId: string;
    shipName: string;
    route:Route;
    schedule: Schedule;
    reserveCapacity: number;
    wListCapacity:number;
    seatingCapacity:number
}
