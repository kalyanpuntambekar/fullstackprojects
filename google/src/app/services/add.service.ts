import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddService {

  register = new BehaviorSubject([]);
  
  constructor(private http: HttpClient) {}

  addDetails(item : any){
    console.log("from service");
    console.log(item);
    return this.http.post<any>('http://localhost:8080/add' , item);
  }


  getDetails(item : any){
    return this.http.post<any>('http://localhost:8080/get' , item);
  }
}
