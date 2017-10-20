import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AngularFireModule} from 'angularfire2';
import {AngularFireDatabaseModule} from 'angularfire2/database';
import {AngularFireAuthModule} from 'angularfire2/auth';
import {AuthService} from './services/auth.service';
import {AuthenticatedGuard} from './guards/authenticated.guard';
import {FirebaseService} from './services/firebase.service';

const firebaseConfig = {
  apiKey: 'AIzaSyCzsHKEQ0M4V1MBCVO026hVVEEbpUZRqEs',
  authDomain: 'devlabs-admin.firebaseapp.com',
  databaseURL: 'https://devlabs-admin.firebaseio.com',
  projectId: 'devlabs-admin',
  storageBucket: 'devlabs-admin.appspot.com',
  messagingSenderId: '207191269191'
};

@NgModule({
  imports: [
    CommonModule,
    AngularFireModule.initializeApp(firebaseConfig),
    AngularFireDatabaseModule,
    AngularFireAuthModule
  ],
  providers: [
    AuthService,
    FirebaseService,
    AuthenticatedGuard
  ],
  declarations: []
})
export class FirebaseModule {
}
