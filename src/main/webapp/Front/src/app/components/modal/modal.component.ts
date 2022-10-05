import { Component, OnInit, Input, Output, EventEmitter  } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  
  @Input() data: any
  @Output() closeModal = new EventEmitter();

  onCloseModal(): void {
    this.closeModal.emit();
  }

  onOkModal(): void {
    this.closeModal.emit();
  }

  constructor() { }

  ngOnInit(): void {

  }

}
