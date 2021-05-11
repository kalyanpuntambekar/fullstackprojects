import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddService {

  constructor(private http: HttpClient) { }

	save(queryForm: FormGroup ): Observable<string> | any {
		console.log(queryForm.value)
		try{
			return this.http.post(`http://localhost:8102/user/create`, queryForm.value);
		}catch(e){
			return e;
		}
		
	}
	find(queryForm: FormGroup ): Observable<string> | any {
		try{
			return this.http.post(`http://localhost:8102/user/find`, queryForm.value);
		}catch(e){
			return e;
		}
		
	}
}
