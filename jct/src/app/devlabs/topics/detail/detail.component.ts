import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {TopicService} from '../services/topic.service';
import {Topic} from '../topic';
import {AuthService} from '../../firebase/services/auth.service';
import {SubscriberService} from '../services/subscriber.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  topic;
  editedTopic;
  editField: string;

  subscribers;

  constructor(private route: ActivatedRoute,
              private topicService: TopicService,
              private authService: AuthService,
              private subService: SubscriberService) {
  }

  ngOnInit() {
    this.editedTopic = {};

    this.route.params
      .subscribe((params: Params) => {
        const topicKey = params['key'];
        this.topicService.get(topicKey).subscribe(topic => this.topic = topic);
        this.subService.getSubscribersFor(topicKey).subscribe(subs => this.subscribers = subs);
      });
  }

  subscribe(topic: Topic) {
    this.authService.userObs.subscribe(user => {
      if (this.subscribers.filter(sub => sub.user.uid === user.uid).length === 0) {
        this.subService.subscribe(topic.$key, user.uid);
      }
    });
  }

  unsubscribe() {
    const toUnsubscribe = this.subscribers.find(sub => sub.user.uid === this.authService.user.uid);
    this.subService.unsubscribe(toUnsubscribe);
  }

  isSubscribed() {
    if (this.subscribers) {
      return this.subscribers.some(sub => this.authService.user.uid === sub.user.uid);
    } else {
      return false;
    }
  }

  edit(key: string) {
    this.editField = key;
  }

}
