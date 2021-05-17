import { Component, OnInit } from '@angular/core';
import { ZipService } from '../services/zip.service';

@Component({
  selector: 'app-zip',
  templateUrl: './zip.component.html',
  styleUrls: ['./zip.component.css']
})
export class ZipComponent implements OnInit {

  isSearched: boolean;
  

  constructor(private readonly service: ZipService) { }

  ngOnInit(): void {
    this.service.isSearched.subscribe(val => this.isSearched = val);
  }


}
