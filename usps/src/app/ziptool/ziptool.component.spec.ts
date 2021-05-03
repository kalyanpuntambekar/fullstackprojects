import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZiptoolComponent } from './ziptool.component';

describe('ZiptoolComponent', () => {
  let component: ZiptoolComponent;
  let fixture: ComponentFixture<ZiptoolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZiptoolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZiptoolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
