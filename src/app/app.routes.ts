import { provideRouter, RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { ContentComponent } from './content/content.component';
export const routes: Routes = [
   // app.routes.ts
   { path: '', component: LoginComponent },
{ path: 'login', component: LoginComponent },
{ path: 'content', component: ContentComponent },

  ];
