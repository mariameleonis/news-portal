package com.epam.newsportal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.epam.newsportal.entity.News;

@Repository
public class NewsDAOImpl implements NewsDAO {
	
	private SessionFactory sessionFactory;
		
	public NewsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<News> getNews() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<News> theQuery = currentSession.createQuery("from News", News.class);
		List<News> news = theQuery.getResultList();
		return news;
	}

	@Override
	public News saveNews(News news) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(news);	
		return news;
	}

	@Override
	public News getNewsById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		News theNews = currentSession.get(News.class, id);
		return theNews;
	}

	@Override
	public int deleteNews(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from News where id=:newsId");
		theQuery.setParameter("newsId", id);
		return theQuery.executeUpdate();				
	}
}
