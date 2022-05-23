import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NewsService } from './services/news.service';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'news-portal';

  constructor(private app: NewsService, private http: HttpClient, private router: Router) {
    this.app.authenticate(undefined, undefined);
  }
  private logoutUrl = `http://localhost:8080/news-portal-java-config/logout`;
  
  logout() {
    this.http.post(this.logoutUrl, {}).pipe(
      finalize(() => {
          this.app.authenticated = false;
          this.router.navigateByUrl('');
      })).subscribe();
  }

  authenticated() { return this.app.authenticated; }

}
