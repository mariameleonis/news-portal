import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { News } from 'src/app/common/news';
import { NavigationService } from 'src/app/services/navigation.service';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-edit-news',
  templateUrl: './edit-news.component.html',
  styleUrls: ['./edit-news.component.css']
})
export class EditNewsComponent implements OnInit {

  news: News = new News();

  constructor(private newsService: NewsService,
              private route: ActivatedRoute, private router: Router, private navigation: NavigationService) { }

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

  update(): void {
    this.newsService.updateNews(this.news)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigateByUrl('/news/' + this.news.id);
      },
      error: (e) => console.error(e)
    }); 
  }

  back(): void {
    this.navigation.back()
  }

}
