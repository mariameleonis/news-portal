import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NewsListComponent } from './components/news-list/news-list.component';
import { HttpClientModule } from '@angular/common/http'
import { NewsService } from './services/news.service';
import { NewsDetailsComponent } from './components/news-details/news-details.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { AddNewsComponent } from './components/add-news/add-news.component';
import { AuthGuard } from './auth/auth.guard';
import { EditNewsComponent } from './components/edit-news/edit-news.component';

const routes: Routes = [
  { path: 'news', component: NewsListComponent},
  { path: 'add-news', component: AddNewsComponent, canActivate: [AuthGuard]},
  { path: 'edit-news/:id', component: EditNewsComponent, canActivate: [AuthGuard]},
  { path: 'news/:id', component: NewsDetailsComponent},
  { path: 'login', component: LoginComponent},
  { path: '', component: NewsListComponent},
  { path: '**', redirectTo: '/news', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    NewsListComponent,
    NewsDetailsComponent,
    LoginComponent,
    AddNewsComponent,
    EditNewsComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [NewsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
