import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCampingComponent } from './detail-camping.component';

describe('DetailCampingComponent', () => {
  let component: DetailCampingComponent;
  let fixture: ComponentFixture<DetailCampingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailCampingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCampingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
