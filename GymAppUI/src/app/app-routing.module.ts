import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CreateWorkoutComponent } from './create-workout/create-workout.component';
import { UpdateSubscriptionComponent } from './update-subscription/update-subscription.component';

const routes: Routes = [
    //{ path: '', redirectTo: '/createworkout', pathMatch: 'full' },
    { path: 'createworkout', component: CreateWorkoutComponent },
    { path: 'updatesubscription', component: UpdateSubscriptionComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }