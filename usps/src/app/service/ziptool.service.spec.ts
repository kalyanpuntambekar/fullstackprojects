import { TestBed } from '@angular/core/testing';

import { ZiptoolService } from './ziptool.service';

describe('ZiptoolService', () => {
  let service: ZiptoolService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZiptoolService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
