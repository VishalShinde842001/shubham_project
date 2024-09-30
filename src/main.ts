import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { LoginComponent } from './app/login/login.component';
import { provideRouter } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { routes } from './app/app.routes';

bootstrapApplication(AppComponent, appConfig
)
  .catch((err) => console.error(err));
