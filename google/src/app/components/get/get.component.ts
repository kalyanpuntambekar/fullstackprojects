import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AddService } from 'src/app/services/add.service';

@Component({
  selector: 'app-get',
  templateUrl: './get.component.html',
  styleUrls: ['./get.component.css']
})
export class GetComponent implements OnInit {

  isSaved = false;
  data: any;

  constructor(private rs: AddService, private http: HttpClient) {

  }

  ngOnInit(): void {
  }

  addContactForm = new FormGroup({
    fname: new FormControl('', [Validators.required]),
    lname: new FormControl('', [Validators.required]),
    // city: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email])
  });

  handleAddContactSubmit() {

    let a = {
      "fname": this.addContactForm.controls.fname.value,
      "lname": this.addContactForm.controls.lname.value,
      // "city": this.addContactForm.controls.city.value,
      "email": this.addContactForm.controls.email.value
    }
    console.log(a);
    this.rs.getDetails(a).subscribe((data: any) => {
      // if (data.length > 0) {
        this.data = data;
        this.isSaved = true;
      // }
    });

  }

}
