import { Component, OnInit } from '@angular/core'
import { FormGroup, FormControl, Validators, FormBuilder, NgForm } from '@angular/forms'
import { HttpClient } from '@angular/common/http'
import { TestModel } from '../..//model/test.model'

@Component({
  selector: 'app-user',
  templateUrl: './test.component.html'
})
export class TestComponent implements OnInit {
  
  form: FormGroup

  constructor(private fb: FormBuilder) {
    this.myForm()
  }

  ngOnInit(): void {

  }
 
  myForm() {
    this.form = this.fb.group({
      email: ['email', Validators.required ]
    });
  }

  register(form: NgForm) {
    console.log(form.controls['email'].value)
    console.log(form.controls['password'].value)
  }

}
