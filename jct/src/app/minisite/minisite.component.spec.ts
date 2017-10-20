import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MinisiteComponent } from './minisite.component';

describe('MinisiteComponent', () => {
  let component: MinisiteComponent;
  let fixture: ComponentFixture<MinisiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MinisiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MinisiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
