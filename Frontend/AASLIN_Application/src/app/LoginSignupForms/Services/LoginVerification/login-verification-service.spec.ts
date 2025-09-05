import { TestBed } from '@angular/core/testing';

import { LoginVerificationService } from './login-verification-service';

describe('LoginVerificationService', () => {
  let service: LoginVerificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginVerificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
