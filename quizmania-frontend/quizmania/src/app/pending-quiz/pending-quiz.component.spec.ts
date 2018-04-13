import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingQuizComponent } from './pending-quiz.component';

describe('PendingQuizComponent', () => {
  let component: PendingQuizComponent;
  let fixture: ComponentFixture<PendingQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
