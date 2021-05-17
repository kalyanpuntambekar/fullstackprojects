import { Component } from '@angular/core';
//import { Query } from '../model/query';
import { FormBuilder, Validators } from '@angular/forms'
import { MailService } from '../mail.service';
@Component({
	selector: 'app-zip',
	templateUrl: './zip.component.html',
	styleUrls: ['./zip.component.css']
})
export class ZipComponent {
	constructor(private fb: FormBuilder, private service : MailService) { }

	//model = new Query('', '', '', '', '');
	res = '';
	err = '';
	queryForm = this.fb.group({
		adr1: ['', [Validators.required]],
		adr2: [''],
		city: ['', [Validators.required]],
		state: ['', [Validators.required, Validators.maxLength(2)]],
		zip: ['', [Validators.required, Validators.maxLength(5)]],
	});

	onSubmit() {
		this.service.apiCall(this.queryForm).subscribe((response: any) => {
			if(Number(response)!==NaN){
				this.err='';
				this.res=response;
			}else{
				this.res='';
				this.err=response;
			}
		}, (err:any)=>{
			this.res='';
			this.err="Information was invalid, no zipcode found"
		});


	}
	get adr1() {
		return this.queryForm.get('adr1');
	}

	get adr2() {
		return this.queryForm.get('adr2');
	}
	
	get city() {
		return this.queryForm.get('city');
	}

	get state() {
		return this.queryForm.get('state');
	}
	
	get zip() {
		return this.queryForm.get('zip');
	}

}
