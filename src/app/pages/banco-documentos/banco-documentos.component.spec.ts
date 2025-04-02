import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BancoDocumentosComponent } from './banco-documentos.component';

describe('BancoDocumentosComponent', () => {
  let component: BancoDocumentosComponent;
  let fixture: ComponentFixture<BancoDocumentosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BancoDocumentosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BancoDocumentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
