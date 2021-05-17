import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ZipService } from '../services/zip.service';

@Component({
  selector: 'app-zip-form',
  templateUrl: './zip-form.component.html',
  styleUrls: ['./zip-form.component.css']
})
export class ZipFormComponent implements OnInit {

  form: FormGroup = new FormGroup({});

  firstName: FormControl;
  lastName: FormControl;
  email: FormControl;
  license: FormControl;
  ssn: FormControl;
  address: FormControl;
  contact: FormControl;
  addressResults: any


  constructor(private readonly zipService: ZipService, private fb: FormBuilder, private _snackBar: MatSnackBar) {
    this.form = fb.group({
      contact: ['', [Validators.required, Validators.pattern("^((\\+1-?)|0)?[0-9]{10}$")]],
      drivingLicense: ['', [Validators.required, Validators.pattern("[0-9]{9}$")]],
      ssn: ['', [Validators.required, Validators.pattern("[0-9]{3}\-[0-9]{2}\-[0-9]{4}")]],
      email: ['', [Validators.required, Validators.email]],
      firstName: ['', [Validators.required, Validators.pattern('^[a-zA-Z \-\']+')]],
      lastName: ['', [Validators.required, Validators.pattern('^[a-zA-Z \-\']+')]],
      address: ['', [Validators.required]],
    });
  }

  get f() {
    return this.form.controls;
  }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.form.value);
    if (!this.form.invalid) {
      this.zipService.submitDetails(this.form.value).subscribe((res) => {
        this.form.reset();
        alert('Data Saved Successfully');
        console.log('Response ', res)
      },(err)=>{
        console.log(err);
        const msg = err && err.error?err.error.message:'UNKNOWN ERROR!';
        alert(msg);
        
      });
    }
  }

  formatSsn(value) {
    if (!this.form.controls.ssn.errors.pattern || value.match(/[0-9]{9}/)) {
      value = value.slice(0, 3) + "-" + value.slice(3, 5) + "-" + value.slice(5, 9);
      console.log(value);
      this.form.controls.ssn.setValue(value);
    }
  }

  getAddress(value) {

    this.zipService.getAddress(value).subscribe(res => {
      this.addressResults = res

    });
  }

}
