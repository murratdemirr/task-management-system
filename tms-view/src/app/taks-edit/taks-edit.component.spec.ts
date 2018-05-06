import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaksEditComponent } from './taks-edit.component';

describe('TaksEditComponent', () => {
  let component: TaksEditComponent;
  let fixture: ComponentFixture<TaksEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaksEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaksEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
