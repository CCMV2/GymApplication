import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CreateWorkoutComponent } from './create-workout/create-workout.component';
import { UpdateSubscriptionComponent } from './update-subscription/update-subscription.component';
import { CreateSubscriptionComponent } from './create-subscription/create-subscription.component';
import { AppRoutingModule } from './app-routing.module';
import { UpdateWorkoutComponent } from './update-workout/update-workout.component';
import { ListWorkoutComponent } from './list-workout/list-workout.component';
import { ListSubscriptionComponent } from './list-subscription/list-subscription.component'
import { RoomPageComponent } from './room-page/room-page.component';;
import { FormsModule } from '@angular/forms';
import { UserPageComponent } from './user-page/user-page.component';
import {BackendService} from './backend.service';
import {HttpModule } from "@angular/http";
import { TimetableComponent } from './timetable/timetable.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateWorkoutComponent,
    UpdateSubscriptionComponent,
    UpdateWorkoutComponent,
    ListWorkoutComponent,
    CreateSubscriptionComponent,
    ListSubscriptionComponent,
    RoomPageComponent,
    UserPageComponent,
    TimetableComponent
  ],
  imports: [
    HttpModule ,
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [BackendService],
  bootstrap: [AppComponent]
})
export class AppModule { }
