import {Component, OnInit} from '@angular/core';
import {TopicService} from '../services/topic.service';
import {Topic} from 'app/devlabs/topics/topic';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {

  topics: Array<Topic>;

  constructor(private topicsService: TopicService) {
  }

  ngOnInit() {
    this.topicsService.topics.subscribe((topics) => this.topics = topics);
  }

  isSubscribed(topic) {
    return this.topicsService.isSubscribed(topic);
  }

}
