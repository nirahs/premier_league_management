import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from '../app/components/home/home.component';
import { ClubsComponent } from '../app/components/clubs/clubs.component';
import { MatchesComponent } from '../app/components/matches/matches.component';
import { NotFoundComponent } from '../app/components/not-found/not-found.component';
import { HelpComponent } from '../app/components/help/help.component'

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'clubs', component:ClubsComponent},
  {path:'matches', component:MatchesComponent},
  {path:'help', component:HelpComponent},
  {path:'**', component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
