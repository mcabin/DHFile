import {  ApplicationConfig, inject, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';
import { JwtInterceptor } from './interceptor/jwt-interceptor.interceptor';
import { provideAppInitializer } from '@angular/core';
import { AuthService } from './service/api/auth-service.service';

export function initializeAuth(authService: AuthService):Promise<void>{
  return authService.checkToken();
}

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    provideRouter(routes), 
    provideClientHydration(),
    provideHttpClient(withInterceptorsFromDi()),
    provideHttpClient(withFetch()),
    provideAppInitializer(() =>initializeAuth(inject(AuthService)))
  ]
  };
