import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KafkaService } from '../services/kafka.service';
import { KafkaComponent } from './kafka.component';

describe('KafkaComponent', () => {
  let kafkaServiceStub: Partial<KafkaService>;
  let component: KafkaComponent;
  let fixture: ComponentFixture<KafkaComponent>;

  beforeEach(async () => {

    await TestBed.configureTestingModule({
      declarations: [ KafkaComponent ],
      providers: [ {provide: KafkaService, useValue: KafkaService}]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KafkaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
