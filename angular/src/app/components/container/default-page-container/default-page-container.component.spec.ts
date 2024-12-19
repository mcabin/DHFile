import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DefaultPageContainerComponent } from './default-page-container.component';

describe('DefaultPageContainerComponent', () => {
  let component: DefaultPageContainerComponent;
  let fixture: ComponentFixture<DefaultPageContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DefaultPageContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DefaultPageContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
