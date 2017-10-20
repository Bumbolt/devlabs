import {Injectable} from '@angular/core';
import {FirebaseService} from '../../firebase/services/firebase.service';
import {Topic} from '../topic';
import {Subject} from 'rxjs/Subject';
import {ReplaySubject} from 'rxjs/ReplaySubject';
import {TagService} from './tag.service';
import {SubscriberService} from './subscriber.service';
import {AuthService} from '../../firebase/services/auth.service';

@Injectable()
export class TopicService {

  topicsPath: string;

  querySubject: Subject<any>;
  originalTopics: Array<Topic>;
  topics: Subject<Array<Topic>>;

  constructor(private firebaseService: FirebaseService,
              private tagService: TagService,
              private subscriberService: SubscriberService,
              private authService: AuthService) {
    this.topicsPath = 'topics';

    this.querySubject = new Subject();
    this.topics = new ReplaySubject();

    firebaseService.all(this.topicsPath).subscribe(original => {
      original.forEach(topic => {
        this.subscriberService.getSubscribersFor(topic.$key).subscribe(subs => {
          topic.subs = subs;
        });
      });
      this.registerFilter(original);
    });
  }

  add(topic: Topic) {
    this.tagService.addTags(topic);
    this.firebaseService.add(this.topicsPath, topic);
  }

  get(key: string) {
    return this.firebaseService.get('topics', key);
  }

  search(params: any) {
    this.querySubject.next(params);
  }

  registerFilter(original) {

    this.originalTopics = original;
    this.topics.next(original);

    this.querySubject.subscribe((query) => {

      let filtered = this.originalTopics;

      if (query.onlyMe) {
        const user = this.authService.user;
        filtered = filtered.filter(topic => {
          return topic.subs.some(sub => {
            return sub.user.uid === user.uid;
          });
        });
      }

      if (query.title) {
        filtered = filtered.filter((topic) => {
          return topic.title.toLowerCase().indexOf(query.title.toLowerCase()) !== -1;
        });
      }

      if (query.tag) {
        filtered = filtered.filter(topic => {
          return topic.tags.find(tag => tag.indexOf(query.tag) !== -1);
        });
      }

      this.topics.next(filtered);
    })
    ;

  }

  isSubscribed(topic: Topic) {
    const user = this.authService.user;

    if (topic.subs) {
      return topic.subs.some(sub => {
        return sub.user.uid === user.uid;
      });
    }
    return false;
  }

  update(topic: Topic) {
    this.tagService.addTags(topic);
    this.firebaseService.update(this.topicsPath, topic);
  }

}
