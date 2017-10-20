import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TopicService} from '../services/topic.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css']
})
export class NewComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private topicService: TopicService,
              private router: Router) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group(
      {
        'title': ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
        'tags': ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
        'description': ['', [Validators.required, Validators.minLength(100)]]
      });
  }

  addTopic() {
    if (this.form.dirty && this.form.valid) {
      const toSave = Object.assign({}, this.form.value);
      toSave.tags = toSave.tags.split(/[\s\t;,._+*|\\]/);
      this.topicService.add(toSave);
      this.router.navigate(['/devlabs', 'topics']);
    }
  }

  get title() {
    return this.form.get('title');
  }

  get tags() {
    return this.form.get('tags');
  }

  get description() {
    return this.form.get('description');
  }


}
