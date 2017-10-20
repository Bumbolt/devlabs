import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../firebase/services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: any;
  authenticated: boolean;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.authService.userObs.subscribe((user) => this.user = user);
    this.authService.authenticated.subscribe((isAuthenticated) => this.authenticated = isAuthenticated);
  }

  login() {
    this.authService.login();
  }

  logout() {
    this.authService.logout();
  }

}
