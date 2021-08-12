import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VillagevDetailComponent } from './villagev-detail.component';
//import 'jasmine';
describe('VillagevDetailComponent', () => {
  let component: VillagevDetailComponent;
  let fixture: ComponentFixture<VillagevDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VillagevDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VillagevDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
