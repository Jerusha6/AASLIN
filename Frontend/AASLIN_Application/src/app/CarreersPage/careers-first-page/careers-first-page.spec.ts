import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CareersFirstPage } from './careers-first-page';

describe('CareersFirstPage', () => {
  let component: CareersFirstPage;
  let fixture: ComponentFixture<CareersFirstPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CareersFirstPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CareersFirstPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
