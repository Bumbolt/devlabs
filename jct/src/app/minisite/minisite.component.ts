import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-minisite',
  templateUrl: './minisite.component.html',
  styleUrls: ['./minisite.component.css']
})
export class MinisiteComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    this.redirect();
  }

  private redirect() {
    window.location.href = 'http://devlabs-admin.firebaseapp.com/minisite/index.html';
  }

}
