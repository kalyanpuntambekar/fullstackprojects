import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AddService } from 'src/app/services/add.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  isSaved = false;

  constructor(private rs: AddService, private http: HttpClient) {

  }

  ngOnInit(): void {
  }

  addContactForm = new FormGroup({
    fname: new FormControl('', [Validators.required]),
    lname: new FormControl('', [Validators.required]),
    Address: new FormControl('', [Validators.required]),
    ssn: new FormControl('', [Validators.required,Validators.pattern("^[0-9]*$"),Validators.minLength(9), Validators.maxLength(9)]),
    pNumber: new FormControl('',[Validators.required,Validators.pattern("^[0-9]*$"),Validators.minLength(9)]),
    email: new FormControl('',  [Validators.required,Validators.email]),
    dl: new FormControl('', [Validators.required])
  });


  handleAddContactSubmit() {
    
    let a = {
      "fname": this.addContactForm.controls.fname.value,
      "lname": this.addContactForm.controls.lname.value,
      "address": this.addContactForm.controls.Address.value,
      "ssn": this.addContactForm.controls.ssn.value,
      "number": this.addContactForm.controls.pNumber.value,
      "email": this.addContactForm.controls.email.value,
      "dl": this.addContactForm.controls.dl.value
    }

    this.rs.addDetails(a).subscribe((data: any) => {
      this.isSaved = data;
    });

  }

}
