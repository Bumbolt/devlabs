import {Component, OnInit} from '@angular/core';
import {TopicService} from '../../services/topic.service';
import {TagService} from '../../services/tag.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  query: any;
  tags: any;

  constructor(private topicsService: TopicService,
              private tagService: TagService) {
  }

  ngOnInit() {
    this.query = {};
    this.tagService.tagsSubject.subscribe(tags => this.tags = tags);
  }

  search() {
    if (this.query.tag === 'all') {
      delete this.query.tag;
    }
    this.topicsService.search(this.query);
  }
}
