package com.epam.newsportal.dao;

import java.util.List;

import com.epam.newsportal.entity.News;

public interface NewsDAO {
	
	public List<News> getNews();

	public News saveNews(News theNews);

	public News getNewsById(long id);

	public int deleteNews(long id);
}
