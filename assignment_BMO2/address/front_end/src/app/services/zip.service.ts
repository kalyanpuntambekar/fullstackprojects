
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, throwError } from 'rxjs';
import { map, catchError, take } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ZipService {

  url = `http://localhost:8080`;

  isSearched = new BehaviorSubject(false);
  searchResults = new BehaviorSubject([]);


  constructor(private readonly http: HttpClient) { }

  submitDetails(body) {
    return this.http.post(`${this.url}/user`, body).
      pipe(catchError(error => {
        // let errorMsg: string;
        // if (error.error instanceof ErrorEvent) {
        //   errorMsg = `Error: ${error.error.message}`;
        // }
        // else {
        //   errorMsg = this.getServerErrorMessage(error);
        // }
        return throwError(error);
      }));

  }


  private getServerErrorMessage(error: HttpErrorResponse): string {
    switch (error.status) {
      case 404: {
        return `Not Found: ${error.message}`;
      } case 403: {
        return `Access Denied: ${error.message}`;
      }case 400:{return `Failed to Save data: ${error.message}`; }
       case 500: { return `Internal Server Error: ${error.message}`; }
      default: { return `Unknown Server Error: ${error.message}`; }
    }
  }

  search(text) {
    return this.http.get(`${this.url}/user/${text}`);
  }

  setSearchResults(value) {
    this.isSearched.next(true);
    this.searchResults.next(value);
  }

  getAddress(value) {
    return this.http.get(`${this.url}/address/${value}`);

  }
}
function catchErro(arg0: (error: any) => any): any {
  throw new Error('Function not implemented.');
}

