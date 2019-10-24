import { Component, OnInit } from '@angular/core';
import { Route } from '../route';
import { Router } from '@angular/router';
import { ShruiseService } from '../shruise.service';

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
  styleUrls: ['./route.component.css']
})
export class RouteComponent implements OnInit {
  routes: Route[];
  
  constructor(private _shruiseService: ShruiseService, private router:Router) { }

  ngOnInit() {
    this._shruiseService. getRoute().subscribe( route => {
      this.routes = route;
    });
  }
  delete(route: Route): void {
    this._shruiseService.deleteRoute(route.routeId).subscribe( data => {
    
      this.routes = this.routes.filter(u => u !== route);
    });
  }
  edit(route: Route): void{
    console.log('edit called');
    this.router.navigate(['/addRoute/', route]);
  }
}
