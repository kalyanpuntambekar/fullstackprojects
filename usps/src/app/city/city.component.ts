import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ZiptoolService } from '../service/ziptool.service';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  isSaved = false;
  State : any;
  City: any;
  constructor(private rs: ZiptoolService, private http: HttpClient) {

  }

  ngOnInit(): void {
  }

  addContactForm = new FormGroup({
    ZipCode: new FormControl('')
  });

  handleAddContactSubmit() {
    
    let a = {
      "ZipCode": this.addContactForm.controls.ZipCode.value
    }

    this.rs.getCity(this.addContactForm.controls.ZipCode.value).subscribe((data: any) => {
      this.City = data.City;
      this.State = data.State;
      this.isSaved = true;
    });

  }
}
