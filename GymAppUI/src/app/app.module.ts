import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CreateWorkoutComponent } from './pages/workout/create-workout/create-workout.component';
import { UpdateSubscriptionComponent } from './pages/subscription/update-subscription/update-subscription.component';
import { CreateSubscriptionComponent } from './pages/subscription/create-subscription/create-subscription.component';
import { AppRoutingModule } from './app-routing.module';
import { UpdateWorkoutComponent } from './pages/workout/update-workout/update-workout.component';
import { ListWorkoutComponent } from './pages/workout/list-workout/list-workout.component';
import { ListSubscriptionComponent } from './pages/subscription/list-subscription/list-subscription.component'
import { RoomPageComponent } from './pages/room/room-page/room-page.component';
import { FormsModule } from '@angular/forms';
import { UserPageComponent } from './pages/user/user-page/user-page.component';
import { BackendService } from './backend.service';
import { HttpModule } from "@angular/http";
//import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TimetableComponent } from './pages/timetable/timetable.component';
import { CreateUserComponent } from './pages/user/create-user/create-user.component';
import { UpdateUserComponent } from './pages/user/update-user/update-user.component';
import { DeleteUserComponent } from './pages/user/delete-user/delete-user.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { NavigationPaneComponent } from './pages/navigation-pane/navigation-pane.component';
import { CreateTimetableComponent } from "./pages/timetable/create-timetable/create-timetable.component";
import { AdminPageComponent } from './pages/admin-page/admin-page.component';
import { ClientPageComponent } from './pages/client-page/client-page.component';

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
    TimetableComponent,
    CreateUserComponent,
    UpdateUserComponent,
    DeleteUserComponent,
    LoginPageComponent,
    CreateTimetableComponent,
    NavigationPaneComponent,
    AdminPageComponent,
    ClientPageComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    //NgbModule.forRoot()
  ],
  providers: [BackendService],
  bootstrap: [AppComponent]
})
export class AppModule { }
