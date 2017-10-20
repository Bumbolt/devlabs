import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FirebaseModule} from './firebase/firebase.module';
import {DevlabsRoutingModule} from './devlabs-routing.module';
import {DevlabsComponent} from './devlabs.component';
import {AdminModule} from './admin/admin.module';
import {ProfileModule} from './profile/profile.module';
import {PublicModule} from './public/public.module';
import {SharedModule} from './shared/shared.module';
import {HeaderComponent} from './shared/header/header.component';
import {FooterComponent} from './shared/footer/footer.component';
import {TopicsModule} from './topics/topics.module';


@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    FirebaseModule,
    AdminModule,
    ProfileModule,
    PublicModule,
    TopicsModule,
    // contains ** route, load last
    DevlabsRoutingModule,
  ],
  declarations: [
    DevlabsComponent,
    HeaderComponent,
    FooterComponent
  ]
})
export class DevlabsModule {
}
