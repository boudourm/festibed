import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterFestivalComponent } from './ajouter-festival.component';

describe('AjouterFestivalComponent', () => {
  let component: AjouterFestivalComponent;
  let fixture: ComponentFixture<AjouterFestivalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterFestivalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterFestivalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
