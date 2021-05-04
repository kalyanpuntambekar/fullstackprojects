import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ZipService {

  url = `http://localhost:8080/api`;

  constructor(private readonly http: HttpClient) { }

  submitForZip4(body) {
    return this.http.post(`${this.url}/location/zip4`, body);
  }
}
