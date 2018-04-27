import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterexamineeComponent } from './registerexaminee.component';

describe('RegisterexamineeComponent', () => {
  let component: RegisterexamineeComponent;
  let fixture: ComponentFixture<RegisterexamineeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterexamineeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterexamineeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
