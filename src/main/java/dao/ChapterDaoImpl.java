package dao;

import java.util.*;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ChapterDaoImpl implements ChapterDao{

	@Autowired  
	public SessionFactory sessionFactory;
	
	public List<Chapter> getAll(Integer bookId) throws Exception {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Book as b WHERE b.id="+bookId);
		Book book = (Book)query.uniqueResult();
		return new ArrayList<Chapter>(book.getChapter());
	}

	public List<Chapter> getAll() throws Exception {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Chapter");
		return query.list();
	}

	public Chapter get(Integer chapterId) throws Exception {
		Session session = sessionFactory.openSession();
		Chapter chapter = (Chapter)session.get(Chapter.class,chapterId);
		return chapter;
	}

	public Chapter getChapterByName(String chapterName) throws Exception {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Chapter.class);
		criteria.add(Restrictions.like("chapterName",chapterName));
		
		Object result = criteria.uniqueResult();
		Chapter chapter = (Chapter) result;
		return chapter;
	}

	public void add(Integer bookId, Chapter chapter) throws Exception {
		Session session = sessionFactory.openSession();
		session.save(chapter);
		
		Book book1 = (Book)session.get(Book.class,bookId);
		book1.getChapter().add(chapter);
		session.saveOrUpdate(book1);
		
	}

	public void addChapter(Chapter chapter) throws Exception {
		Session session = sessionFactory.openSession();
		Chapter chapter1 = new Chapter();
		chapter1.setChapterId(chapter.getChapterId());
		chapter1.setChapterName(chapter.getChapterName());
		session.save(chapter1);
	}

	public void edit(Chapter chapter) throws Exception {
		Session session = sessionFactory.openSession();
		Chapter chapter1 = (Chapter)session.get(Chapter.class,chapter.getChapterId());
		chapter1.setChapterId(chapter.getChapterId());
		chapter1.setChapterName(chapter.getChapterName());
		session.saveOrUpdate(chapter1);
	}

	public void deleteChapter(Integer chapterId) throws Exception {
		Session session = sessionFactory.openSession();
		Chapter chapter = (Chapter)session.get(Chapter.class,chapterId);
		session.delete(chapter);
	}

}
