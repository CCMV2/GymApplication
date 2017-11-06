import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CreateWorkoutComponent } from './create-workout/create-workout.component';
import { UpdateSubscriptionComponent } from './update-subscription/update-subscription.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateWorkoutComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: 'createworkout', component: CreateWorkoutComponent},
      {path: 'updatesubscription', component: UpdateSubscriptionComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
