import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ RouterModule,Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import{ HttpClientModule } from '@angular/common/http';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { ShruiceService } from './shruice.service';
import { LoginComponent } from './login/login.component';
import { AddshipComponent } from './addship/addship.component';
import { ShiplistComponent } from './shiplist/shiplist.component';
import { HomeComponent } from './home/home.component';

const appRoute:Routes = [
  {path: 'register',  component:RegisterComponent},
  {path:'userdetails', component:UserdetailsComponent},
  {path:'addship', component:AddshipComponent},
  {path:'shiplist', component:ShiplistComponent},
  {path:'login', component:LoginComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    UserdetailsComponent,
    LoginComponent,
    AddshipComponent,
    ShiplistComponent,
    HomeComponent
   
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoute),FormsModule,HttpClientModule, ReactiveFormsModule
  ],
  providers: [ShruiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
