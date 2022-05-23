import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { News } from 'src/app/common/news';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit {

  news: News = new News();

  constructor(private newsService: NewsService,
              private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleNewsDetails();
    })
  }

  handleNewsDetails() {

    const theNewsId: number = +this.route.snapshot.paramMap.get('id')!;

    this.newsService.getSingleNews(theNewsId).subscribe(
      data => {
        this.news = data;
      }
    )
  }

  delete(): void {  
    if(confirm("Are you sure?")) {
      this.newsService.deleteNews(this.news.id)
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
