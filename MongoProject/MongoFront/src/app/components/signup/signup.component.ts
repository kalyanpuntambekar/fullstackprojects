import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'
import { AddService } from '../../services/add.service';
import { MapsAPILoader } from "@agm/core";
@Component({
	selector: 'app-signup',
	templateUrl: './signup.component.html',
	styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
	bounds: any;
	options: any;
	test: any;
	constructor(private fb: FormBuilder, private service: AddService, private mapsAPILoader: MapsAPILoader) { }
	ngOnInit(): void {
		this.mapsAPILoader.load().then(() => {
			this.bounds = new google.maps.LatLngBounds(
				new google.maps.LatLng(54.69726685890506, -2.7379201682812226),
				new google.maps.LatLng(55.38942944437183, -1.2456105979687226)
			);
		this.options = {
			bounds: this.bounds,
			componentRestrictions: { country: "us" },
			fields: ["address_components", "geometry", "icon", "name"],
			origin: this.bounds.getCenter(),
			strictBounds: false,
			types: ["establishment"],
		};
		this.test="loaded";
		});
	}
	formattedaddress = " ";
	drop:any;
	res = '';
	err = '';
	queryForm = this.fb.group({
		fname: ['', [Validators.required]],
		lname: ['', [Validators.required]],
		adr: ['', [Validators.required]],
		city: [''],
		drive: ['', [Validators.required, Validators.maxLength(12), Validators.minLength(12)]],
		ssn: ['', [Validators.required, Validators.maxLength(9), Validators.minLength(9)]],
		phone: ['', [Validators.required, Validators.maxLength(10), Validators.minLength(10)]],
		email: ['', [Validators.required, Validators.email]]
	});

	onSubmit() {
		this.service.save(this.queryForm).subscribe((response: any) => {
			if (Number(response) !== NaN) {
				this.err = '';
				this.res = response;
			} else {
				this.res = '';
				this.err = response;
			}
		}, (err: any) => {
			this.res = '';
			this.err = "Information was invalid, no zipcode found"
		});


	}
	public setValue(x:string){
		this.queryForm.patchValue({adr: x})
		this.drop=""
	}
	// without
	public backChange(address: any){
		this.service.fill(address.value).subscribe((response: any) => {
			this.drop=response
		}, (err: any) => {
			console.log(err);
		});
	}
	// with  ngx-google-places-autocomplete 
	public AddressChange(address: any) {
		this.queryForm.patchValue({adr:address.name, city:address.vicinity})
		console.log(address);
		this.formattedaddress = address.formatted_address
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
