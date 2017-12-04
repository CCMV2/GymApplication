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


const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuardGuard] },
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
    { path: 'updateuser', component: UpdateUserComponent, canActivate: [AuthGuardGuard]},
    { path: 'listusers', component: UserPageComponent, canActivate: [AuthGuardGuard]},
    { path: 'subscriptiondetails', component: SubscriptionDetailsComponent, canActivate: [AuthGuardGuard]},
    { path: 'demo', component: DemoComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
