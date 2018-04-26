import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewQuizzesComponent } from './viewquizzes.component';

describe('ViewquizzesComponent', () => {
  let component: ViewQuizzesComponent;
  let fixture: ComponentFixture<ViewQuizzesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewQuizzesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
