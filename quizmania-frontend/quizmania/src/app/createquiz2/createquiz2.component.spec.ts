import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Createquiz2Component } from './createquiz2.component';

describe('Createquiz2Component', () => {
  let component: Createquiz2Component;
  let fixture: ComponentFixture<Createquiz2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Createquiz2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Createquiz2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
