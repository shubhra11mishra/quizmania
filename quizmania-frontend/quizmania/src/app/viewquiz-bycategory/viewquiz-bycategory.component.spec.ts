import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewquizBycategoryComponent } from './viewquiz-bycategory.component';

describe('ViewquizBycategoryComponent', () => {
  let component: ViewquizBycategoryComponent;
  let fixture: ComponentFixture<ViewquizBycategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewquizBycategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewquizBycategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
