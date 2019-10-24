import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddshipComponent } from './addship.component';

describe('AddshipComponent', () => {
  let component: AddshipComponent;
  let fixture: ComponentFixture<AddshipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddshipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddshipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
