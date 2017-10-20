import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {DevlabsModule} from './devlabs/devlabs.module';
import { MinisiteComponent } from './minisite/minisite.component';

@NgModule({
  declarations: [
    AppComponent,
    MinisiteComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,

    DevlabsModule,

    AppRoutingModule
  ],
  providers: [],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {
}
