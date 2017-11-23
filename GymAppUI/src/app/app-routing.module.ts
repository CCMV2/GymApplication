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
import {DeleteUserComponent} from './pages/user/delete-user/delete-user.component';
import {LoginPageComponent} from './pages/login-page/login-page.component';
import {UpdateUserComponent} from './pages/user/update-user/update-user.component';
import {UserPageComponent} from "./pages/user/user-page/user-page.component";
import {CreateTimetableComponent} from "./pages/timetable/create-timetable/create-timetable.component";
import {AdminPageComponent} from "./pages/admin-page/admin-page.component";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'admin-page', component: AdminPageComponent},
  {path: 'createworkout', component: CreateWorkoutComponent},
  {path: 'updatesubscription', component: UpdateSubscriptionComponent},
  {path: 'updateworkout', component: UpdateWorkoutComponent},
  {path: 'listworkout', component: ListWorkoutComponent},
  {path: 'createsubscription', component: CreateSubscriptionComponent},
  {path: 'listsubscription', component: ListSubscriptionComponent},
  {path: 'roompage', component: RoomPageComponent},
  {path: 'timetable', component: TimetableComponent},
  {path: 'newtimetable', component: CreateTimetableComponent},
  {path: 'createuser', component: CreateUserComponent},
  {path: 'deleteuser', component: DeleteUserComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'updateuser', component: UpdateUserComponent},
  {path: 'listusers', component: UserPageComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
