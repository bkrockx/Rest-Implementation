package service;

import java.util.*;

import model.*;
import dao.*;

public interface BookService {
	
	public void addBook(Book book) throws Exception;  
	 public Book getBookById(Integer bookId) throws Exception;  
	 public List<Book> getBookList() throws Exception;  
	 public void deleteBook(long bookId) throws Exception;  
	 
}
