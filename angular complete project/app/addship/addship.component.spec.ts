import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddShipComponent } from './addship.component';

describe('AddShipComponent', () => {
  let component: AddShipComponent;
  let fixture: ComponentFixture<AddShipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddShipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddShipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
