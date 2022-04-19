package com.epam.newsportal.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.newsportal.dao.NewsDAOImpl;
import com.epam.newsportal.dto.NewsDTO;
import com.epam.newsportal.entity.News;

@Service
public class NewsServiceImpl implements NewsService {
	
	private final NewsDAOImpl newsDAO;
	
	public NewsServiceImpl(NewsDAOImpl newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	@Transactional
	public List<NewsDTO> getNews() {
		List<NewsDTO> newsDTOList = new ArrayList<>();
        List<News> newsList = newsDAO.getNews();
        for (News news : newsList) {
            newsDTOList.add(convertNewsEntityToDTO(news));
        }
        newsDTOList.sort(Comparator.comparing(NewsDTO::getDate, Collections.reverseOrder()));
        return newsDTOList;
	}

	@Override
	@Transactional
	public NewsDTO saveNews(NewsDTO newsDTO) {	
		return convertNewsEntityToDTO(newsDAO.saveNews(convertNewsDTOToEntity(newsDTO)));
	}

	@Override
	@Transactional
	public NewsDTO getNewsById(long id) {
		
		if (newsDAO.getNewsById(id) == null) return null;
		
		return convertNewsEntityToDTO(newsDAO.getNewsById(id));
	}

	@Override
	@Transactional
	public void deleteNews(long id) {
		newsDAO.deleteNews(id);
	}

	@Override
	@Transactional
	public int deleteNews(List<Long> listId) {
		int totalNewsDeleted = 0;
	        for (Long id : listId) {
	        	totalNewsDeleted += newsDAO.deleteNews(id);
	        }	
	        
	    return totalNewsDeleted;
	}
	
	private NewsDTO convertNewsEntityToDTO(News news) {
		NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setTitle(news.getTitle());
        newsDTO.setBrief(news.getBrief());
        newsDTO.setContent(news.getContent());
        newsDTO.setDate(news.getDate().toString());
        return newsDTO;
	}

	private News convertNewsDTOToEntity(NewsDTO newsDTO) {
		News news = new News();
        news.setId(newsDTO.getId());
        news.setTitle(newsDTO.getTitle());
        news.setBrief(newsDTO.getBrief());
        news.setContent(newsDTO.getContent());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        news.setDate(LocalDate.parse(newsDTO.getDate(), formatter));
        return news;
	}
}
