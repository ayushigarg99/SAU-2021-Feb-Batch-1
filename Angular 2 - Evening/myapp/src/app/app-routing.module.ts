import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SessionAddComponent } from './session-add/session-add.component'
import { SessionListComponent } from './session-list/session-list.component'

const routes: Routes = [
  {
    path:'list',
    component:SessionListComponent,
  },
  {
    path:'add',
    component:SessionAddComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),RouterModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
