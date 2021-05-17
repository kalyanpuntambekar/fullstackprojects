import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'
import { AddService } from '../../services/add.service';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

    constructor(private fb: FormBuilder, private service : AddService) { }
	res:any;
	err = '';
	queryForm = this.fb.group({
		fname: ['', [Validators.required]],
		lname: ['', [Validators.required]],
		adr: ['', [Validators.required]],
		drive: ['', [Validators.required]],
		ssn: ['', [Validators.required]],
		phone: ['', [Validators.required]],
		email: ['', [Validators.required]]
	});
	ngOnInit(): void {
		
	}
	onSubmit() {
		this.service.find(this.queryForm).subscribe((response: any) => {
			if(Number(response)!==NaN){
				this.err='';
				this.res=response;
			}else{
				this.res='';
				this.err=response;
			}
		}, (err:any)=>{
			this.res='';
			this.err="Information was invalid, no user found"
		});


	}
	get fname() {
		return this.queryForm.get('fname');
	}
	get lname() {
		return this.queryForm.get('lname');
	}
	get ssn() {
		return this.queryForm.get('ssn');
	}
	get phone() {
		return this.queryForm.get('phone');
	}
	get email() {
		return this.queryForm.get('email');
	}
	get adr(){
		return this.queryForm.get('adr');
	}
	get drive(){
		return this.queryForm.get('drive');
	}
}
