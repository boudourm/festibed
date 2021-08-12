import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CampingComponent } from './Camping.component';

describe('CampingComponent', () => {
  let component: CampingComponent;
  let fixture: ComponentFixture<CampingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CampingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CampingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
