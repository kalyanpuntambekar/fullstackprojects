import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup } from '@angular/forms'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MailService {

  constructor(private http: HttpClient) { }
	res = '';
	err = '';

	apiCall(queryForm: FormGroup ): Observable<string> | any {
		
		//var url = `https://production.shippingapis.com/ShippingAPI.dll?API=Verify&XML=<AddressValidateRequest USERID="683TATAC4313"><Address ID="0"><Address1>${queryForm.value.adr1}</Address1><Address2>${queryForm.value.adr2}</Address2><City>${queryForm.value.city}</City><State>${queryForm.value.state}</State><Zip5>${queryForm.value.zip}</Zip5><Zip4></Zip4></Address></AddressValidateRequest>`
		try{
			return this.http.get<string>(`http://localhost:8080/api/xml?adr1=${queryForm.value.adr1}&adr2=${queryForm.value.adr2}&city=${queryForm.value.city}&state=${queryForm.value.state}&zip=${queryForm.value.zip}`);
		}catch(e){
			return e;
		}
		
	}
	lookup(queryForm: FormGroup ): Observable<string> | any {
		var zip:string[];
		zip=[queryForm.value.zip, queryForm.value.zip2, queryForm.value.zip3, queryForm.value.zip4, queryForm.value.zip5]
		var filtZip = zip.filter(function (el) {
  			return el != "";
		});
		console.log(filtZip);
		try{
			return this.http.get(`http://localhost:8080/api/lookup?zip=${filtZip}`, { responseType: 'text'});
		}catch(e){
			console.log(e);
			return e;
		}
		
	}
}
