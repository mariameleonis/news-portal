import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { News } from 'src/app/common/news';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {

  news: News[];
  SelectionStatusOfNews: any = {};

  constructor(private newsService: NewsService, private router: Router) { }

  ngOnInit(): void {
   
      this.listNews();
   
  }

  listNews() {
    this.newsService.getNewsList().subscribe(
      data => {
        this.news = data;
      }
    )
  }

  deleteList() {
    let selectedNews = Object.keys(this.SelectionStatusOfNews)
    .filter((item, index) => {
      return this.SelectionStatusOfNews[item];  
  });
  
  if(selectedNews.length == 0) {
    alert("At list 1 news should be checked!");
    return;
  }

  if(confirm("Are you sure?")) {
    this.newsService.deleteNewsList(selectedNews)
  .subscribe({
    next: (res) => {
      console.log(res);
    },
    error: (e) => console.error(e)
  });
  this.router.navigateByUrl('/news')
  .then(() => {
    window.location.reload();
  });
  }  
  }
  authenticated() { return this.newsService.authenticated; }
}
