package dao;

import java.util.*;

import javax.annotation.Resource;
import javax.transaction.Transaction;

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

//@Transactional
public class BookDaoImpl implements BookDao{
	
	@Autowired  
	public SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	public void addBook(Book book) throws Exception {
		Session session = sessionFactory.openSession();
		session.save(book);
		session.close();
		/*
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(book);
		*/
	}

	public Book getBookById(Integer bookId) throws Exception {
		
		Session session = sessionFactory.openSession();
		return (Book)session.get(Book.class,bookId);
		
		
		/*
		session = sessionFactory.openSession();
		Book book = (Book)session.load(Book.class,bookId);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return book;
		*/
	}

	public List<Book> getBookList() throws Exception {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Book");
		return query.list();
		
		/*
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Book> bookList = session.createCriteria(Book.class).list();
		tx.commit();
		session.close();
		return bookList;
		*/
	}

	public void deleteBook(Integer bookId) throws Exception {
		
		Session session = sessionFactory.openSession();
		Book book = (Book)session.get(Book.class,bookId);
		session.delete(book);
		session.close();
		
		/*
		session = sessionFactory.openSession();
		Object o = session.load(Book.class,bookId);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		*/
	}
	
	
	public void deleteBook(long bookId) throws Exception {
		
		Session session = sessionFactory.openSession();
		Book book = (Book)session.get(Book.class,bookId);
		session.delete(book);
		session.close();
		/*
		session = sessionFactory.openSession();
		Object o = session.load(Book.class,bookId);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		*/	
	}
	

}
