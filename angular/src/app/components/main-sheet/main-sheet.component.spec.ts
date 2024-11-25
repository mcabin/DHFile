import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainSheetComponent } from './main-sheet.component';

describe('MainSheetComponent', () => {
  let component: MainSheetComponent;
  let fixture: ComponentFixture<MainSheetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MainSheetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
