import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileRoutingModule } from './profile-routing.module';
import { ProfileComponent } from './profile.component';
import {FirebaseModule} from '../firebase/firebase.module';
import {TopicsModule} from '../topics/topics.module';
import {TopicsComponent} from '../topics/topics/topics.component';
import {SharedModule} from '../shared/shared.module';
import {DevlabsModule} from '../devlabs.module';

@NgModule({
  imports: [
    CommonModule,
    ProfileRoutingModule,
    FirebaseModule,
    TopicsModule
  ],
  declarations: [
    ProfileComponent
  ]
})
export class ProfileModule { }
