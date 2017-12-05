import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CreateWorkoutComponent } from './pages/workout/create-workout/create-workout.component';
import { UpdateSubscriptionComponent } from './pages/subscription/update-subscription/update-subscription.component';
import { CreateSubscriptionComponent } from './pages/subscription/create-subscription/create-subscription.component';
import { AppRoutingModule } from './app-routing.module';
import { UpdateWorkoutComponent } from './pages/workout/update-workout/update-workout.component';
import { ListWorkoutComponent } from './pages/workout/list-workout/list-workout.component';
import { ListSubscriptionComponent } from './pages/subscription/list-subscription/list-subscription.component';
import { RoomPageComponent } from './pages/room/room-page/room-page.component';
import { FormsModule } from '@angular/forms';
import { UserPageComponent } from './pages/user/user-page/user-page.component';
import { BackendService } from './backend.service';
import { HttpModule } from '@angular/http';
//import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TimetableComponent } from './pages/timetable/timetable.component';
import { CreateUserComponent } from './pages/user/create-user/create-user.component';
import { UpdateUserComponent } from './pages/user/update-user/update-user.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { NavigationPaneComponent } from './pages/navigation-pane/navigation-pane.component';
import { CreateTimetableComponent } from './pages/timetable/create-timetable/create-timetable.component';
import { AdminPageComponent } from './pages/admin-page/admin-page.component';
import { ClientPageComponent } from './pages/client-page/client-page.component';
import {SessionStorageService} from 'ngx-webstorage';
import { HomeComponent } from './pages/home/home/home.component';
import { AuthGuardGuard } from './services/auth-guard.guard';
import { HeaderComponent } from './common/header/header.component';
import { UpdateTimetableComponent } from './pages/timetable/update-timetable/update-timetable.component';
import { SideButtonComponent } from './tool-box/side-button/side-button.component';
import {CalendarModule, MultiSelectModule} from 'primeng/primeng';
import { AgmCoreModule } from '@agm/core';
import { StarRatingModule } from 'angular-star-rating';
import { SubscriptionDetailsComponent } from './pages/subscription/subscription-details/subscription-details.component';
import { DemoComponent } from './pages/demo/demo.component';
import { ContactComponent } from './pages/contact/contact.component';
import { AuthenticationService } from "./pages/demo/services/authentication.service";
import { TrainerComponent } from './pages/trainer/trainer.component';
import { UserTimetableComponent } from './pages/user/user-timetable/user-timetable.component';


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
    LoginPageComponent,
    CreateTimetableComponent,
    NavigationPaneComponent,
    SideButtonComponent,
    AdminPageComponent,
    ClientPageComponent,
    HomeComponent,
    HeaderComponent,
    UpdateTimetableComponent,
    SubscriptionDetailsComponent,
    DemoComponent,
    ContactComponent,
    TrainerComponent,
    UserTimetableComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    CalendarModule,
    MultiSelectModule,
    AgmCoreModule.forRoot({
        // sa inlocuiti cheia
        apiKey: 'AIzaSyBlV0xjA3L_OjqbMNXyqX_i1Hx9Pft38Jw'
      }),
    //NgbModule.forRoot()
      StarRatingModule.forRoot()
  ],
  providers: [BackendService,
              AuthenticationService,
              AuthGuardGuard,
              SessionStorageService
              ],
  bootstrap: [AppComponent]
})
export class AppModule { }
