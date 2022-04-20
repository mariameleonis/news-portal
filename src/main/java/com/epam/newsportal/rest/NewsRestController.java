package com.epam.newsportal.rest;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.epam.newsportal.dto.NewsDTO;
import com.epam.newsportal.service.NewsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class NewsRestController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/news")
	public ResponseEntity<List<NewsDTO>> getNews() {
		return ResponseEntity.ok(newsService.getNews());
	}
	
	@GetMapping("/news/{newsId}")
	public ResponseEntity<NewsDTO> getSingleNews(@PathVariable long newsId) {
		NewsDTO newsDTO = newsService.getNewsById(newsId);
		
		if (newsDTO == null) {
			throw new NewsNotFoundException("News id not found - " + newsId);
		}
		return ResponseEntity.ok(newsDTO);
	}
	
	@PostMapping("/news")
	public ResponseEntity<NewsDTO> addNews(@Valid @RequestBody NewsDTO newsDTO) {
		return new ResponseEntity<NewsDTO>(newsService.saveNews(newsDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/news")
	public ResponseEntity<NewsDTO> updateNews(@Valid @RequestBody NewsDTO newsDTO) {
		return new ResponseEntity<NewsDTO>(newsService.saveNews(newsDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/news/{newsId}")
	public ResponseEntity<String> deleteNewsById(@PathVariable long newsId) {
		NewsDTO newsDTO = newsService.getNewsById(newsId);
		
		if (newsDTO == null) {
			throw new NewsNotFoundException("News id not found - " + newsId);
		}
		
		newsService.deleteNews(newsId);
		return ResponseEntity.ok("News with id " + newsId + " was deleted.");
	}
	
	@PostMapping("/news/deleteList")
	public ResponseEntity<String> deleteNewsList(@RequestBody List<String> body) {
		List<Long> idList = new ArrayList<Long>();
        for (String stringId : body ) {
            try {
                idList.add(Long.valueOf(stringId));
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("Failed to delete News list: invalid id format");
            }
        }
        
        return ResponseEntity.ok(newsService.deleteNews(idList) + " raws was deleted.");
	}
}
