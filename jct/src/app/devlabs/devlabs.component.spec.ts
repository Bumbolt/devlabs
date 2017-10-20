import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DevlabsComponent } from './devlabs.component';

describe('DevlabsComponent', () => {
  let component: DevlabsComponent;
  let fixture: ComponentFixture<DevlabsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DevlabsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DevlabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
