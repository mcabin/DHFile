import { Routes } from '@angular/router';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { LogPageComponent } from './components/log-page/log-page.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { DefaultPageContainerComponent } from './components/container/default-page-container/default-page-container.component';
import { AuthGuard } from './auth.guard';
import { MainSheetComponent } from './components/main-sheet/main-sheet.component';

export const routes: Routes = [
    { path: 'home-page',
        component:DefaultPageContainerComponent,  data:{dynamicContent:HomePageComponent
        },
        canActivate:[AuthGuard]

    },
    {path:'signup',component: SignUpComponent},
    {path: 'login',component: LogPageComponent},
    {path: '',redirectTo:'home-page',pathMatch:'full'},
    {path: 'sheet',component:MainSheetComponent}
];
