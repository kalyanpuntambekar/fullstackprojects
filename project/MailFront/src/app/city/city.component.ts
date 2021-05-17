import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'
import { MailService } from '../mail.service';
@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent {

	constructor(private fb: FormBuilder, private service : MailService) { }

	res = '';
	err = '';
	

	queryForm = this.fb.group({
		zip: ['', [Validators.required, Validators.maxLength(5), Validators.minLength(5)]],
		zip2: ['',[Validators.maxLength(5), Validators.minLength(5)]],
		zip3: ['',[Validators.maxLength(5), Validators.minLength(5)]],
		zip4: ['', [Validators.maxLength(5), Validators.minLength(5)]],
		zip5: ['', [Validators.maxLength(5), Validators.minLength(5)]],
	});

	onSubmit() {
		this.service.lookup(this.queryForm).subscribe((response: any) => {
			this.res=response;
			this.err='';
		}, (err:any)=>{
			this.res='';
			console.log(err)
			this.res=err.error.text
		});


	}
		get zip() {
		return this.queryForm.get('zip');
	}
		get zip2() {
		return this.queryForm.get('zip2');
	}
		get zip3() {
		return this.queryForm.get('zip3');
	}
		get zip4() {
		return this.queryForm.get('zip4');
	}
		get zip5() {
		return this.queryForm.get('zip5');
	}

}
