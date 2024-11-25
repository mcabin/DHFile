import { Routes } from '@angular/router';
import { CharacterComponent } from './components/character/character.component';
import { ItemComponent } from './components/item/item.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { LogPageComponent } from './components/log-page/log-page.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    {path:'character' ,component: CharacterComponent},
    {path:'item',component:ItemComponent},
    {path:'signup',component: SignUpComponent},
    {path: 'login',component: LogPageComponent}
];
