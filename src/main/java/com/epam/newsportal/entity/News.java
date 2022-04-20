package com.epam.newsportal.entity;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_id_generator")
    @SequenceGenerator(name = "news_id_generator", sequenceName = "NEWS_ID_SEQ", allocationSize = 1)
	private long id;
	
	@Column(name="NEWS_DATE")
	private LocalDate date;
	
	private String title;
	
	private String brief;
	
	private String content;
	
	public News() {
		
	}

	public News(long id, String title, String brief, String content, LocalDate date) {
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(title, news.title) &&
                Objects.equals(brief, news.brief) &&
                Objects.equals(content, news.content) &&
                Objects.equals(date, news.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, brief, content, date);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }	
}

