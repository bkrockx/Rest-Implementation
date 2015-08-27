package controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import model.Book;
import model.Chapter;
import model.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.*;
import service.*;


//@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping(value="/book", produces={MediaType.APPLICATION_JSON_VALUE})
//@RequestMapping("/book")
@Controller
@RequestMapping(value="/restDemo")
public class RestBookController {
	
	@Autowired
	ChapterService chapterService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	ChapterDao chapterDao;
	
	@Autowired
	BookDao bookDao;
	
	static final Logger logger = Logger.getLogger(BookController.class);
	
	@RequestMapping(value="/hello")
	public String hello(Model model){
		//model.addAttribute("bookAttribute", new Book());
		return "Hello";
	}
	
	// to add a book 
	/*
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public @ResponseBody
	Status addBook(@RequestBody Book book){
		try{
			bookService.addBook(book);
			return new Status(1,"book added successfully");
		}catch(Exception e){
			return new Status(0, e.toString());
		}
	}
	*/
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd() {  	
		/*
		model.addAttribute("bookAttribute", new Book());
	    */
	    return "Hello";
	}
	 
	/*    
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody 
	List<Book>postAdd(@ModelAttribute("bookAttribute") Book book) throws Exception {		
		bookService.addBook(book);
		List<Book> bookList = null;
		try{
			bookList = bookService.getBookList();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("bookList returned");
		System.out.println(bookList);
		return bookList;
		//return "redirect:/book/hello";
	}
	*/
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody 
	Book postAdd(@RequestBody Book book) throws Exception {
		//Book book1 = new Book();
		//book1.setBookId(book.getBookId());
		//book1.setBookName(book.getBookName());
		bookService.addBook(book);
		System.out.println("entering into post");
		System.out.println(book.getBookId() + " " + book.getBookName());
		return book;
		
	}
	
	// to get a particular book
	@RequestMapping(value="/book/{bookId}",method = RequestMethod.GET)
	public @ResponseBody
	Book getBook(@PathVariable("bookId")Integer bookId){
		Book book = null;
		try{
			System.out.println("entering into try");
			book = bookService.getBookById(bookId);
			System.out.println("got book by id");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("book returned");
		System.out.println(book.getBookName());
		ObjectMapper mapper = new ObjectMapper();
		StringWriter sw= new StringWriter();
		try {
			System.out.println("1");
			mapper.writeValue(sw, book);
			System.out.println("1.5" + sw.toString());
			System.out.println("2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	// to get the list of all the books
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody
	List<Book> getBookList(){
		List<Book> bookList = null;
		try{
			bookList = bookService.getBookList();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("bookList returned");
		System.out.println(bookList);
		return bookList;
	}
	
	// to delete a particular book
	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.GET)
	public @ResponseBody()
	Status deleteEmployee(@PathVariable("bookId") long bookId) {
		try {
			bookService.deleteBook(bookId);;
			return new Status(1, "book deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
	
}
