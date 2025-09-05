import { TestBed } from '@angular/core/testing';

import { MailOtpVerification } from './mail-otp-verification';

describe('MailOtpVerification', () => {
  let service: MailOtpVerification;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MailOtpVerification);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
