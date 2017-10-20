import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DevlabsComponent} from './devlabs.component';
import {PublicComponent} from './public/public.component';
import {OverviewComponent} from './topics/overview/overview.component';
import {NewComponent} from './topics/new/new.component';
import {EditComponent} from './topics/edit/edit.component';
import {DetailComponent} from './topics/detail/detail.component';
import {TopicsComponent} from './topics/topics/topics.component';

const routes: Routes = [
  {
    path: 'devlabs',
    component: DevlabsComponent,
    children: [
      {
        path: 'public',
        component: PublicComponent,
      },
      {
        path: 'topics',
        component: TopicsComponent,
        children: [
          {
            path: '',
            component: OverviewComponent
          },
          {
            path: 'new',
            component: NewComponent
          },
          {
            path: 'edit/:key',
            component: EditComponent
          },
          {
            path: ':key',
            component: DetailComponent,
          }
        ]
      },
      {
        path: '**',
        component: PublicComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DevlabsRoutingModule { }
