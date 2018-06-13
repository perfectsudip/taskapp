import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTasklogComponent } from './edit-tasklog.component';

describe('EditTasklogComponent', () => {
  let component: EditTasklogComponent;
  let fixture: ComponentFixture<EditTasklogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditTasklogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTasklogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
