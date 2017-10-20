import {Injectable} from '@angular/core';
import {AngularFireDatabase, FirebaseListObservable, FirebaseObjectObservable} from 'angularfire2/database';

@Injectable()
export class FirebaseService {

  lists: Array<FirebaseListObservable<any>>;
  objects: Array<FirebaseObjectObservable<any>>;

  constructor(private afDb: AngularFireDatabase) {
    this.objects = [];
    this.lists = [];

    this.lists['topics'] = afDb.list('topics');
    this.lists['tags'] = afDb.list('tags');
    this.lists['subscribers'] = afDb.list('subscribers');
    this.lists['users'] = afDb.list('users');
  }

  all(path: string) {
    return this.lists[path];
  }

  add(path: string, object: any) {
    this.lists[path].push(object);
  }

  update(path: string, object: any) {
    const key = object.$key;
    delete object.$key;
    this.lists[path].update(key, object);
  }

  remove(path: string, key: string) {
    this.lists[path].remove(key);
  }

  get(path: string, key: string) {
    const object = this.objects[`${path}/${key}`];

    if (object) {
      return object;
    } else {
      this.objects[`${path}/${key}`] = this.afDb.object(`${path}/${key}`);
      return this.objects[`${path}/${key}`];
    }
  }
}
