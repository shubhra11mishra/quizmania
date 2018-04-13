import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizStatusNoComponent } from './quiz-status-no.component';

describe('QuizStatusNoComponent', () => {
  let component: QuizStatusNoComponent;
  let fixture: ComponentFixture<QuizStatusNoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuizStatusNoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizStatusNoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
