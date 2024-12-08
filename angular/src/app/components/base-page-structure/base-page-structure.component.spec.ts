import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasePageStructureComponent } from './base-page-structure.component';

describe('BasePageStructureComponent', () => {
  let component: BasePageStructureComponent;
  let fixture: ComponentFixture<BasePageStructureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BasePageStructureComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BasePageStructureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
