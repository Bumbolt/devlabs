import {Component, OnInit} from '@angular/core';
import {AuthService} from '../firebase/services/auth.service';

@Component({
  selector: 'app-public',
  templateUrl: './public.component.html',
  styleUrls: ['./public.component.css']
})
export class PublicComponent implements OnInit {

  authenticated: boolean;

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.authService.authenticated.subscribe(isAuthenticated => this.authenticated = isAuthenticated);
  }


  login() {
    this.authService.login();
  }
}
