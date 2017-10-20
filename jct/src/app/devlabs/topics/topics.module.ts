import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {TopicsRoutingModule} from './topics-routing.module';
import {TopicsComponent} from './topics/topics.component';
import {OverviewComponent} from './overview/overview.component';
import {SearchComponent} from './overview/search/search.component';
import {NewComponent} from './new/new.component';
import {DetailComponent} from './detail/detail.component';
import {TopicService} from './services/topic.service';
import {FirebaseModule} from '../firebase/firebase.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TagService} from './services/tag.service';
import {SubscriberService} from './services/subscriber.service';
import { EditComponent } from './edit/edit.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    TopicsRoutingModule,
    FirebaseModule
  ],
  declarations: [
    TopicsComponent,
    OverviewComponent,
    SearchComponent,
    NewComponent,
    DetailComponent,
    EditComponent
  ],
  providers: [
    TopicService,
    TagService,
    SubscriberService
  ],
  exports: [
    TopicsComponent
  ]
})
export class TopicsModule {
}
