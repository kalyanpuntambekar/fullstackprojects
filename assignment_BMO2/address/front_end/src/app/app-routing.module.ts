import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from './search/search.component';
import { ZipComponent } from './zip/zip.component';

const routes: Routes = [
  {
    path: '',
    component: ZipComponent
  },
  {
    path: 'search',
    component: SearchComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
