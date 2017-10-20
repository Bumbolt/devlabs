import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {FirebaseService} from '../../firebase/services/firebase.service';
import {Topic} from '../topic';

@Injectable()
export class TagService {

  tagsSubject: Subject<Array<string>>;

  constructor(private firebaseService: FirebaseService) {
    this.tagsSubject = new Subject();
    this.all();
  }

  all() {
    this.firebaseService.all('tags').subscribe(tags => this.tagsSubject.next(tags));
  }

  addTags(topic: Topic) {
    topic.tags.forEach(tag => this.addTag(tag));
  }

  addTag(tag: string) {
    this.firebaseService.add('tags', tag);
  }

}
