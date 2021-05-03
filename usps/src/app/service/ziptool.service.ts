import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import {map} from 'rxjs/operators';
import * as JsonToXML from "js2xmlparser";

@Injectable({
  providedIn: 'root'
})
export class ZiptoolService {
  private baseURL = 'https://secure.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup&XML=';
  private url = 'http://localhost:3000/hello';
  register = new BehaviorSubject([]);
  
  constructor(private http: HttpClient) {}

  getZip(item : any){
    return this.http.post<any>('http://localhost:8080/code' , item);
  }


  getCity(item : any){
    return this.http.post<any>('http://localhost:8080/city' , {"ZipCode" : item});
  }
}

