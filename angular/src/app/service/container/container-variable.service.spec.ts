import { TestBed } from '@angular/core/testing';

import { ContainerVariableService } from './container-variable.service';

describe('ContainerVariableService', () => {
  let service: ContainerVariableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContainerVariableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
