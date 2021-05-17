import { Component, OnInit } from '@angular/core';
import { AnonymousSubject } from 'rxjs/internal/Subject';
import { ZipService } from '../services/zip.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchText: string;
  // searchResults: any;
  noResults: boolean;
  displayedColumns: string[] = ['firstName', 'lastName', "address", 'ssn', 'contact', 'email', 'drivingLicense'];
  dataSource: any;

  constructor(private readonly searchService: ZipService) { }

  ngOnInit(): void {
  }

  search(val) {
    if (val != "" && val.length >= 3) {
      this.searchService.search(val).subscribe((res: any) => {
        this.dataSource = res;
        this.noResults = res && res.length == 0;
      },(err) => alert(err.message));
    }
  }

}
