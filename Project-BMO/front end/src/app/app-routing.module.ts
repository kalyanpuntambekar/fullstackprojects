import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ZipComponent } from './zip/zip.component';

const routes: Routes = [
  {
    path: '',
    component: ZipComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
