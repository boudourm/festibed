import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FestivalListeComponent } from './festival-liste.component';

describe('FestivalListeComponent', () => {
  let component: FestivalListeComponent;
  let fixture: ComponentFixture<FestivalListeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FestivalListeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FestivalListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
