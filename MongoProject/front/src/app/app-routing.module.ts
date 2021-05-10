import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from "./components/signup/signup.component";
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
const routes: Routes = [
	{ path: '', component: HomeComponent },
	{ path: 'sign', component: SignupComponent },
	{ path: 'search', component: SearchComponent },
	{ path: '**', component: PagenotfoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
