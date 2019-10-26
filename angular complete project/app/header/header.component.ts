import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  template: ` <nav class="navbar">

  <!-- logo -->
  <div class="navbar-brand">
    <a class="navbar-item">
      <img src="/assets/shruise.jpg">
    </a>
  </div>
</nav>`,
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
