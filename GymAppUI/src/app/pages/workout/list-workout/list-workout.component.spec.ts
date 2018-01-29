import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListWorkoutComponent } from './list-workout.component';

describe('ListWorkoutComponent', () => {
  let component: ListWorkoutComponent;
  let fixture: ComponentFixture<ListWorkoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListWorkoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListWorkoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
