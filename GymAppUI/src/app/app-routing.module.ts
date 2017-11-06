import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CreateWorkoutComponent } from './create-workout/create-workout.component';
import { UpdateSubscriptionComponent } from './update-subscription/update-subscription.component';
import { UpdateWorkoutComponent } from './update-workout/update-workout.component';
import { ListWorkoutComponent } from './list-workout/list-workout.component';
import { CreateSubscriptionComponent } from './create-subscription/create-subscription.component';

const routes: Routes = [
    //{ path: '', redirectTo: '/createworkout', pathMatch: 'full' },
    { path: 'createworkout', component: CreateWorkoutComponent },
    { path: 'updatesubscription', component: UpdateSubscriptionComponent },
    { path: 'updateworkout', component: UpdateWorkoutComponent},
    { path: 'listworkout', component: ListWorkoutComponent},
    { path: 'createsubscription', component: CreateSubscriptionComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }