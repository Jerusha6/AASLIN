import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotPasswordUpdate } from './forgot-password-update';

describe('ForgotPasswordUpdate', () => {
  let component: ForgotPasswordUpdate;
  let fixture: ComponentFixture<ForgotPasswordUpdate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ForgotPasswordUpdate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ForgotPasswordUpdate);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
