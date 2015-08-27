package dao;

import java.util.*;
import model.*;

public interface BookDao {
	
	 public void addBook(Book book) throws Exception;  
	 public Book getBookById(Integer bookId) throws Exception;  
	 public List<Book> getBookList() throws Exception;  
	 public void deleteBook(Integer bookId) throws Exception;  
	 public void deleteBook(long bookId) throws Exception;  

}
