import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedQuizComponent } from './approved-quiz.component';

describe('ApprovedQuizComponent', () => {
  let component: ApprovedQuizComponent;
  let fixture: ComponentFixture<ApprovedQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApprovedQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprovedQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
