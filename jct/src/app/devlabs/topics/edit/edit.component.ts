import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {TopicService} from '../services/topic.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Topic} from '../topic';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  topic = {
    title: 'Loading..',
    tagString: 'Loading..',
    tags: [],
    description: 'Loading..'
  };
  form: FormGroup;

  constructor(private route: ActivatedRoute,
              private topicService: TopicService,
              private router: Router,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.createForm();
    this.loadTopic();
  }

  private loadTopic() {
    this.route.params
      .subscribe((params: Params) => {
        const topicKey = params['key'];
        this.topicService.get(topicKey)
          .subscribe(topic => {
            this.topic = topic;
            this.reverseMutateLikeACompleteRetard();
          });
      });
  }

  private createForm() {
    this.form = this.formBuilder.group(
      {
        'title': [
          this.topic.title,
          [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(20)
          ]
        ],
        'tagString': [
          this.topic.tagString,
          [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(30)
          ]
        ],
        'description': [
          this.topic.description,
          [
            Validators.required,
            Validators.minLength(100)
          ]
        ]
      });
  }

  editTopic() {
    this.mutateLikeACompleteRetard();
    this.topicService.update(this.topic);
    this.router.navigate(['/devlabs', 'topics']);
  }

  private mutateLikeACompleteRetard() {
    const splitTags = this.topic.tagString.trim().split(/[\s\t;,._+*|\\]/);
    delete this.topic.tagString;
    this.topic.tags = splitTags;
  }

  private reverseMutateLikeACompleteRetard() {
    this.topic.tagString = this.topic.tags.join(' ');
  }

  get title() {
    return this.form.get('title');
  }

  get tagString() {
    return this.form.get('tagString');
  }

  get description() {
    return this.form.get('description');
  }

}
