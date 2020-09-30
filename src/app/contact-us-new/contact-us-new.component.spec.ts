import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactUsNewComponent } from './contact-us-new.component';

describe('ContactUsNewComponent', () => {
  let component: ContactUsNewComponent;
  let fixture: ComponentFixture<ContactUsNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContactUsNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactUsNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
