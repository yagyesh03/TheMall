import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectoryNewComponent } from './directory-new.component';

describe('DirectoryNewComponent', () => {
  let component: DirectoryNewComponent;
  let fixture: ComponentFixture<DirectoryNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirectoryNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectoryNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
