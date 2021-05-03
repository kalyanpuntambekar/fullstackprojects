import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CityComponent } from './city/city.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ZipComponent } from './zip/zip.component';

const routes: Routes = [
	{ path: '', component: HomeComponent },
	{ path: 'send', component: ZipComponent },
	{ path: 'mail', component: CityComponent },
	{ path: '**', component: PageNotFoundComponent },
	
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
