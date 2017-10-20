import {Injectable} from '@angular/core';
import {FirebaseService} from '../../firebase/services/firebase.service';
import {Subject} from 'rxjs/Subject';
import {ReplaySubject} from 'rxjs/ReplaySubject';
import {AuthService} from '../../firebase/services/auth.service';

@Injectable()
export class SubscriberService {

  subscriberSubject: Subject<any>;
  subscriberUserSubject: Subject<any>;

  constructor(private firebaseService: FirebaseService,
              private authService: AuthService) {
    this.subscriberSubject = new ReplaySubject(1);
    this.subscriberUserSubject = new ReplaySubject(1);
  }

  all() {
    return this.firebaseService.all('subscribers');
  }

  subscribe(topicKey: string, userKey: string) {
    this.firebaseService.add('subscribers', {user: {uid: userKey}, topic: topicKey});
  }

  unsubscribe(sub: any) {
    this.firebaseService.remove('subscribers', sub.$key);
  }

  getSubscribersFor(topicKey: string) {
    const subsSubject = new ReplaySubject(1);

    this.firebaseService.all('subscribers').subscribe(subscribers => {
      let filtered = subscribers.filter((sub) => sub.topic === topicKey);
      filtered = this.fetchUsers(filtered);
      subsSubject.next(filtered);
    });
    return subsSubject;
  }

  getSubscribersForUser(uid: string) {
    this.firebaseService.all('subscribers').subscribe(subscribers => {
      subscribers = this.fetchUsers(subscribers);
      const filtered = subscribers.filter((sub) => sub.user.uid === uid);
      this.subscriberUserSubject.next(filtered);
    });
    return this.subscriberUserSubject;

  }

  fetchUsers(subs: Array<any>) {
    this.firebaseService.all('users').subscribe(usersInDb => {
      usersInDb.filter(userInDb => {
        subs.forEach(sub => {
          if (sub.user.uid === userInDb.uid) {
            sub.user = userInDb;
          }
        });
      });
    });
    return subs;
  }
}
