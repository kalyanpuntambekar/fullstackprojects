import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './components/add/add.component';
import { GetComponent } from './components/get/get.component';

const routes: Routes = [
  {path: '', component: AddComponent},
  {path: 'fetch', component: GetComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
