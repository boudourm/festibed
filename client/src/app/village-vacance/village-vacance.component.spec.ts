import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VillageVacanceComponent } from './village-vacance.component';

describe('VillageVacanceComponent', () => {
  let component: VillageVacanceComponent;
  let fixture: ComponentFixture<VillageVacanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VillageVacanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VillageVacanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
