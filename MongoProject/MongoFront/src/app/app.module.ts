import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from "./components/signup/signup.component";
import { SearchComponent } from './components/search/search.component';
import { HttpClientModule } from '@angular/common/http';
import { GooglePlaceModule } from "ngx-google-places-autocomplete";
import { AgmCoreModule } from '@agm/core';
import { HomeComponent } from './components/home/home.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';

@NgModule({
  declarations: [
	SignupComponent,
    AppComponent,

    SearchComponent,
     HomeComponent,
     PagenotfoundComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	ReactiveFormsModule,
    AppRoutingModule,
	HttpClientModule,
	GooglePlaceModule,
	AgmCoreModule.forRoot({apiKey: "AIzaSyCQ5SKnyZyr29i3GqOooIFPWDSnAzGnbk0"}),
	
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
