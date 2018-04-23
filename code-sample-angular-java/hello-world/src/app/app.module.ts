import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';

import { AppComponent }         from './app.component';
import { AppRoutingModule }     from './app-routing.module';

import { DashboardComponent }   from './components/dashboard/dashboard.component';
import { HeroDetailsComponent }  from './components/hero-details/hero-details.component';
import { HeroesComponent }      from './components/heroes/heroes.component';
import { HeroService }          from './services/hero.service';
import { MessageService }       from './services/message.service';
import { MessageComponent }    from './components/message/message.component';
import { HttpConfig } from "./configs/http-config";


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    HeroesComponent,
    HeroDetailsComponent,
    MessageComponent
  ],
  providers: [ HeroService, MessageService, HttpConfig ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
