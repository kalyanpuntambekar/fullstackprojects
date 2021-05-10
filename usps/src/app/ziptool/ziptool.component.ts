import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ZiptoolService } from '../service/ziptool.service';

@Component({
  selector: 'app-ziptool',
  templateUrl: './ziptool.component.html',
  styleUrls: ['./ziptool.component.css']
})
export class ZiptoolComponent implements OnInit {
  isSaved = false;
  zip4 : number;
  constructor(private rs: ZiptoolService, private http: HttpClient) {

  }

  ngOnInit(): void {
  }

  addContactForm = new FormGroup({
    Address1: new FormControl(''),
    Address2: new FormControl(''),
    City: new FormControl(''),
    State: new FormControl(''),
    ZipCode: new FormControl('')
  });

  handleAddContactSubmit() {
    
    const n = this.addContactForm.controls.Address1.value;

    let a = {
      "Address1": this.addContactForm.controls.Address2.value,
      "Address2": this.addContactForm.controls.Address1.value,
      "City": this.addContactForm.controls.City.value,
      "State": this.addContactForm.controls.State.value,
      "ZipCode": this.addContactForm.controls.ZipCode.value
    }

    this.rs.getZip(a).subscribe((data: number) => {
      this.zip4 = data;
      this.isSaved = true;
    });

  }

}
