package com.epam.newsportal.service;

import java.util.List;

import com.epam.newsportal.dto.NewsDTO;

public interface NewsService {
	
	public List<NewsDTO> getNews();

	public NewsDTO saveNews(NewsDTO newsDTO);
	
	public NewsDTO getNewsById(long id);
	
	public void deleteNews(long id);
	
	public int deleteNews(List<Long> id);

}
