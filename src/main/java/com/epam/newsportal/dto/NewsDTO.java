package com.epam.newsportal.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.epam.newsportal.validator.ValidDate;

public class NewsDTO {
	
	private long id;
	
	@NotEmpty
	@Size(min = 10, max = 100)
	private String title;
	
	@NotEmpty
	@Size(min = 50, max = 500)
	private String brief;
	
	@NotEmpty
	@Size(min = 200, max = 2048)
	private String content;
	
	@ValidDate
	@NotEmpty
	private String date;

	public NewsDTO() {
	}

	public NewsDTO(long id, @NotEmpty @Size(min = 10, max = 100) String title, @NotEmpty @Size(min = 50, max = 500) String brief,
			@NotEmpty @Size(min = 200, max = 2048) String content, @NotEmpty String date) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		NewsDTO newsDTO = (NewsDTO) o;
		return id == newsDTO.id &&
				Objects.equals(title, newsDTO.title) && 
				Objects.equals(brief, newsDTO.brief) && 
				Objects.equals(content, newsDTO.content) && 
				Objects.equals(date, newsDTO.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, brief, content, date);
	}

	@Override
	public String toString() {
		return "NewsDTO{" + "id=" + id + ", title='" + title + '\'' + ", brief='" + brief + '\'' + ", content='"
				+ content + '\'' + ", date='" + date + '\'' + '}';
	}
}
