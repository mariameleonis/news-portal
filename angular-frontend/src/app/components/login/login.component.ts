import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {username: '', password: ''};
  error = false;

  constructor(private newsService: NewsService, private http: HttpClient, private router: Router) { }

  login() {
    this.newsService.authenticate(this.credentials, () => {
        this.router.navigateByUrl('/');
    }); 
    this.error = true; 
    return false;
  }

  ngOnInit(): void {
  }

}
