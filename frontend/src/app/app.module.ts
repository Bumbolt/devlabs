import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AddTopicComponent } from './components/add-topic/add-topic.component';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';

export const routes: Routes = [
  {
    path: 'add-topic', component: AddTopicComponent
  }, {
    path: '**', component: HomeComponent
  }, {
    path: 'devlabs', component: HomeComponent
  }
  ];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    AddTopicComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
