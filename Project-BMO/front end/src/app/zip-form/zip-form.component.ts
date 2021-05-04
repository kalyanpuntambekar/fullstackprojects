import { Component, OnInit } from '@angular/core';
import { ZipService } from '../services/zip.service';

@Component({
  selector: 'app-zip-form',
  templateUrl: './zip-form.component.html',
  styleUrls: ['./zip-form.component.css']
})
export class ZipFormComponent implements OnInit {

  address: string;
  address2: string;
  city: string;
  state: string;
  postalCode: string;
  zip4: string;

  constructor(private readonly zipService: ZipService) { }

  ngOnInit(): void {
  }

  submit() {
    const body = {
      address: this.address,
      address1: this.address2,
      city: this.city,
      state: this.state,
      zip5: this.postalCode
    }
    this.zipService.submitForZip4(body).subscribe(res => {
      this.zip4 = res['zip4'];
    })
  }

}
