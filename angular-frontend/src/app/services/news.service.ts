import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { News } from '../common/news';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  deleteNews(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  deleteNewsList(idList: any): Observable<any> {
    return this.httpClient.post(this.baseUrl + '/deleteList', idList);
  }

  updateNews(data: News): Observable<News> {
    return this.httpClient.put<News>(this.baseUrl, data);
  }

  private baseUrl = environment.newsPortalApiUrl + '/news';
  authenticated = false;
  redirectUrl: string = '/';

  authenticate(credentials: any, callback: any) {

    const userUrl = environment.newsPortalApiUrl + '/user';

    const headers = new HttpHeaders(credentials ? {
        authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.httpClient.get(userUrl, {headers: headers}).subscribe((response: any) => {
        if (response['name']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
    });
  }

  getSingleNews(theNewsId: number): Observable<News> {
    
    const newsUrl = `${this.baseUrl}/${theNewsId}`;

    return this.httpClient.get<News>(newsUrl);
  }

  

  constructor(private httpClient: HttpClient) { }

  getNewsList(): Observable<News[]> {
    return this.httpClient.get<News[]>(this.baseUrl);
  }

  addNews(data: News): Observable<News> {
    return this.httpClient.post<News>(this.baseUrl, data);
  }
}


