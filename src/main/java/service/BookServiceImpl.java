package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.*;
import model.*;

@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	public void addBook(Book book) throws Exception {
		bookDao.addBook(book);	
	}

	public Book getBookById(Integer bookId) throws Exception {
		return bookDao.getBookById(bookId);
	}

	public List<Book> getBookList() throws Exception {
		return bookDao.getBookList();
	}

	public void deleteBook(Integer bookId) throws Exception {
		 bookDao.deleteBook(bookId);
	}

	public void deleteBook(long bookId) throws Exception {
		bookDao.deleteBook(bookId);		
	}

}
