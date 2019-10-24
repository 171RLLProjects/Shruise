import { Location } from "./location";
export class Route {
    routeId: string;
    distance:number;
    duration: string;
    costPerKm:number;
    source: Location;
    destination: Location;
}
