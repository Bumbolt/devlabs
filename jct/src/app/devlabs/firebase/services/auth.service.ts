import {Injectable} from '@angular/core';
import {AngularFireAuth} from 'angularfire2/auth';

import * as firebase from 'firebase/app';
import {Subject} from 'rxjs/Subject';
import {ReplaySubject} from 'rxjs/ReplaySubject';
import {Router} from '@angular/router';
import {FirebaseService} from './firebase.service';

@Injectable()
export class AuthService {

  user;
  userObs;
  authenticated: Subject<boolean>;

  constructor(private afAuth: AngularFireAuth,
              private firebaseService: FirebaseService,
              private router: Router) {

    this.authenticated = new ReplaySubject(1);
    this.userObs = afAuth.authState;
    this.userObs.subscribe((user) => {
      this.authenticated.next(user !== null);
      this.user = user;
    });
  }

  login() {
    this.afAuth.auth.signInWithPopup(new firebase.auth.GoogleAuthProvider())
      .then((user) => {
        if (user) {
          this.firebaseService.all('users').subscribe(users => {
              const isInDb = users.filter(dbUser => dbUser.uid === user.user.uid).length > 0;
              if (!isInDb) {
                this.firebaseService.add('users', {uid: user.user.uid, displayName: user.user.displayName});
              }
              this.authenticated.next(true);
              this.router.navigate(['/devlabs', 'topics']);
            }
          );
        }
      });
  }

  logout() {
    this.afAuth.auth.signOut().then(
      () => {
        this.authenticated.next(false);
        this.router.navigate(['/devlabs', 'public']);
      }
    );
  }
}
