import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BishtPaymentComponent } from './bisht-payment.component';

describe('BishtPaymentComponent', () => {
  let component: BishtPaymentComponent;
  let fixture: ComponentFixture<BishtPaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BishtPaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BishtPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
