import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { News } from 'src/app/common/news';
import { NavigationService } from 'src/app/services/navigation.service';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-add-news',
  templateUrl: './add-news.component.html',
  styleUrls: ['./add-news.component.css']
})
export class AddNewsComponent implements OnInit {

  news = new News();

  constructor(private newsService: NewsService, private router: Router, private navigation: NavigationService) { }

  ngOnInit(): void {
  }

  add(): void {
    this.newsService.addNews(this.news)
    .subscribe(
      {
      next: (res) => {
        console.log(res);
        this.router.navigateByUrl('/news/' + res.id);
      },
      error: (e) => console.error(e)
    });
  }

  back(): void {
    this.navigation.back()
  }

}
