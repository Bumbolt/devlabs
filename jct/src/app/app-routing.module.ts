import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DevlabsComponent} from './devlabs/devlabs.component';
import {MinisiteComponent} from './minisite/minisite.component';

const routes: Routes = [
  {
    path: '',
    component: MinisiteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
