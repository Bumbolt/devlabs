import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminRoutingModule} from './admin-routing.module';
import {AdminComponent} from './admin.component';
import {FirebaseModule} from '../firebase/firebase.module';
import {TopicsModule} from '../topics/topics.module';

@NgModule({
  imports: [
    CommonModule,
    AdminRoutingModule,
    FirebaseModule,
    TopicsModule
  ],
  declarations: [
    AdminComponent
  ]
})
export class AdminModule {
}
