package com.epam.newsportal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentMatchers;
import com.epam.newsportal.dao.NewsDAOImpl;
import com.epam.newsportal.dto.NewsDTO;
import com.epam.newsportal.entity.News;

import static com.epam.newsportal.NewsTestData.*;

@ExtendWith(MockitoExtension.class)
public class NewsServiceImplTest {
	
	@Mock
	private NewsDAOImpl newsDAO;
	
	@InjectMocks
	private NewsServiceImpl newsService;
	
    public NewsDTO newsDTO;
    public News news;

    @BeforeEach
    void setup() {
    	newsDTO = new NewsDTO(NEWS_ID_1, TEST_TEXT, TEST_TEXT, TEST_TEXT, TEST_STRING_DATE);
		news = new News(NEWS_ID_1, TEST_TEXT, TEST_TEXT, TEST_TEXT, TEST_DATE);
    }

	@Test
	public void saveNewsTest() {
		when(newsDAO.saveNews(news)).thenReturn(news);
		NewsDTO resultNewsDTO = newsService.saveNews(newsDTO);
		assertTrue(resultNewsDTO.equals(newsDTO));
		verify(newsDAO).saveNews(news);
	}
	
	@Test
	public void getAllNewsTest() {
		List<News> testNewsList = new ArrayList<>();
        testNewsList.add(news);
        List<NewsDTO> expectedNewsDTOList =  new ArrayList<>();
        expectedNewsDTOList.add(newsDTO);
        when(newsDAO.getNews()).thenReturn(testNewsList);
        List<NewsDTO> resultList = newsService.getNews();
        assertTrue(expectedNewsDTOList.get(0).equals(resultList.get(0)));
        verify(newsDAO).getNews();
	}
	
	@Test
	public void getNewsById() {
		when(newsDAO.getNewsById(news.getId())).thenReturn(news);
        NewsDTO resultNewsDTO = newsService.getNewsById(news.getId());
        assertTrue(resultNewsDTO.equals(newsDTO));
		verify(newsDAO).getNewsById(news.getId());
	}
	
	@Test
	public void getNewsById_WhenNotFound() {
		when(newsDAO.getNewsById(news.getId())).thenReturn(null);
        NewsDTO resultNewsDTO = newsService.getNewsById(news.getId());
        assertTrue(resultNewsDTO == null);
		verify(newsDAO).getNewsById(news.getId());
	}
	
	@Test
	public void deleteNewsTest() {
		newsService.deleteNews(news.getId());
		verify(newsDAO).deleteNews(news.getId());
	}
	
	@Test
	public void deleteNewsList() {
		List<Long> testNewsList = new ArrayList<Long>();
        testNewsList.add(NEWS_ID_1);
        testNewsList.add(NEWS_ID_2);
        int expectedNewsDeleted = testNewsList.size();
        when(newsDAO.deleteNews(ArgumentMatchers.anyLong())).thenReturn(1);
        int resultNewsDeleted = newsService.deleteNews(testNewsList);
        assertTrue(resultNewsDeleted == expectedNewsDeleted);
        verify(newsDAO, times(expectedNewsDeleted)).deleteNews(ArgumentMatchers.anyLong());
	}

}
