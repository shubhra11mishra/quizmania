import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamineeAttemptedQuizzesComponent } from './examinee-attempted-quizzes.component';

describe('ExamineeAttemptedQuizzesComponent', () => {
  let component: ExamineeAttemptedQuizzesComponent;
  let fixture: ComponentFixture<ExamineeAttemptedQuizzesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamineeAttemptedQuizzesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamineeAttemptedQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
