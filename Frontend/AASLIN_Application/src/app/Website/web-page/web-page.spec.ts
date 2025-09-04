import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebPage } from './web-page';

describe('WebPage', () => {
  let component: WebPage;
  let fixture: ComponentFixture<WebPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WebPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WebPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
