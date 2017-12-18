import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {CreateWorkoutComponent} from './pages/workout/create-workout/create-workout.component';
import {UpdateSubscriptionComponent} from './pages/subscription/update-subscription/update-subscription.component';
import {UpdateWorkoutComponent} from './pages/workout/update-workout/update-workout.component';
import {ListWorkoutComponent} from './pages/workout/list-workout/list-workout.component';
import {CreateSubscriptionComponent} from './pages/subscription/create-subscription/create-subscription.component';
import {ListSubscriptionComponent} from './pages/subscription/list-subscription/list-subscription.component';
import {RoomPageComponent} from './pages/room/room-page/room-page.component';
import {TimetableComponent} from './pages/timetable/timetable.component';
import {CreateUserComponent} from './pages/user/create-user/create-user.component';
import {LoginPageComponent} from './pages/login-page/login-page.component';
import {UpdateUserComponent} from './pages/user/update-user/update-user.component';
import {UserPageComponent} from './pages/user/user-page/user-page.component';
import { HomeComponent } from './pages/home/home/home.component';
import {CreateTimetableComponent} from './pages/timetable/create-timetable/create-timetable.component';
import {AdminPageComponent} from './pages/admin-page/admin-page.component';
import { AuthGuardGuard } from './services/auth-guard.guard';
import { UpdateTimetableComponent } from './pages/timetable/update-timetable/update-timetable.component';
import {SubscriptionDetailsComponent} from './pages/subscription/subscription-details/subscription-details.component';
import { DemoComponent } from './pages/demo/demo.component';
import { ContactComponent } from './pages/contact/contact.component';
import { UserTimetableComponent } from './pages/user/user-timetable/user-timetable.component';
import { TrainerComponent } from './pages/trainer/trainer.component';
import { ScheduleComponent } from './pages/timetable/schedule/schedule.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
    { path: 'admin-page', component: AdminPageComponent},
    { path: 'createworkout', component: CreateWorkoutComponent, canActivate: [AuthGuardGuard] },
    { path: 'updatesubscription', component: UpdateSubscriptionComponent, canActivate: [AuthGuardGuard] },
    { path: 'updateworkout', component: UpdateWorkoutComponent, canActivate: [AuthGuardGuard]},
    { path: 'listworkout', component: ListWorkoutComponent, canActivate: [AuthGuardGuard]},
    { path: 'createsubscription', component: CreateSubscriptionComponent, canActivate: [AuthGuardGuard] },
    { path: 'listsubscription', component: ListSubscriptionComponent, canActivate: [AuthGuardGuard] },
    { path: 'roompage', component: RoomPageComponent, canActivate: [AuthGuardGuard] },
    { path: 'timetable', component: TimetableComponent, canActivate: [AuthGuardGuard] },
    { path: 'updateTimetable', component: UpdateTimetableComponent, canActivate: [AuthGuardGuard] },
    { path: 'newtimetable', component: CreateTimetableComponent, canActivate: [AuthGuardGuard] },
    { path: 'createuser', component: CreateUserComponent, canActivate: [AuthGuardGuard]},
    { path: 'login', component: LoginPageComponent},
    { path: 'contact', component: ContactComponent},
    { path: 'updateuser', component: UpdateUserComponent, canActivate: [AuthGuardGuard]},
    { path: 'listusers', component: UserPageComponent, canActivate: [AuthGuardGuard]},
    { path: 'subscriptiondetails', component: SubscriptionDetailsComponent},
    { path: 'demo', component: DemoComponent},
    { path: 'usertimetable', component: UserTimetableComponent, canActivate: [AuthGuardGuard]},
    { path: 'trainer', component: TrainerComponent},
    { path: 'schedule', component: ScheduleComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
