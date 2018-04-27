import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewquizcategoriesComponent } from './viewquizcategories.component';

describe('ViewquizcategoriesComponent', () => {
  let component: ViewquizcategoriesComponent;
  let fixture: ComponentFixture<ViewquizcategoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewquizcategoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewquizcategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
