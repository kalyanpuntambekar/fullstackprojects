import { TestBed } from '@angular/core/testing';

import { AddgetService } from './addget.service';

describe('AddgetService', () => {
  let service: AddgetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddgetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
