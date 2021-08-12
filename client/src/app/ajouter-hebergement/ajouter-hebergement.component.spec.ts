import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterHebergementComponent } from './ajouter-hebergement.component';

describe('AjouterHebergementComponent', () => {
  let component: AjouterHebergementComponent;
  let fixture: ComponentFixture<AjouterHebergementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterHebergementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterHebergementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
