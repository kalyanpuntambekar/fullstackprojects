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
		Fname: ['', [Validators.required]],
		Lname: ['', [Validators.required]],
		adr: ['', [Validators.required]],
		drive: ['', [Validators.required]],
		ssn: ['', [Validators.required]],
		num: ['', [Validators.required]],
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
	get Fname() {
		return this.queryForm.get('Fname');
	}
	get Lname() {
		return this.queryForm.get('Lname');
	}
	get ssn() {
		return this.queryForm.get('ssn');
	}
	
	get num() {
		return this.queryForm.get('num');
	}

	get email() {
		return this.queryForm.get('email');
	}
}
