import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterexaminerComponent } from './registerexaminer.component';

describe('RegisterexaminerComponent', () => {
  let component: RegisterexaminerComponent;
  let fixture: ComponentFixture<RegisterexaminerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterexaminerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterexaminerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
