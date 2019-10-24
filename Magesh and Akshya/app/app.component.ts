import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <section class="hero is-info is-fullheight is-bold">
    <div class="hero-body">
    <div class="container">
  
  
  <h1>Welcome to Mphasis</h1>,
  <div style="padding:15px">
  <ul class="nav nav-tabs">
   
  
   <li><a routerLink='userdetails'>User</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
   <li><a routerLink='register'>Register</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
   <li><a routerLink='addship'>AddShip</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
   <li><a routerLink='login'>Login</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
  
  
   </ul>
  <br/><br/>
 <router-outlet></router-outlet>

 </div>
 </div>
    </div>
    </section>
  `,
  styles: [`
  .hero {
    height: 100%;
    background-image: url('/assets/img/collage1.jpg') !important;
    background-size: cover;
    background-position: center center;
  }
`]
})
export class AppComponent {
  title = 'ShipCruise';

}
