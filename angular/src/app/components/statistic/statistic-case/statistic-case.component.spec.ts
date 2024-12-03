import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticCaseComponent } from './statistic-case.component';

describe('StatisticCaseComponent', () => {
  let component: StatisticCaseComponent;
  let fixture: ComponentFixture<StatisticCaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatisticCaseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatisticCaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
