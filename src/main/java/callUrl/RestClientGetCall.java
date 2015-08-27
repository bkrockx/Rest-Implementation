package callUrl;

import org.apache.log4j.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.apache.log4j.Logger.getLogger;

import org.springframework.web.client.RestTemplate;

import dao.*;
import model.*;
import service.*;
import controller.*;


public class RestClientGetCall {
	
	private static final Logger LOGGER = getLogger(RestClientGetCall.class);
	
	public static void main(String[] args) throws IOException{
		
		 LOGGER.debug("Starting REST Client!!!!");
		
		 
		try{
			//Map<String,String> vars = new HashMap<String,String>();
			//vars.put(key, value);
			RestTemplate restTemplate = new RestTemplate();
			
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			
			/*
			String url = "http://localhost:8080/restApp/restDemo/book/1";
			Book book1 = restTemplate.getForObject(url,Book.class);
			*/
			
			//printing the contents of book object obtained
			//System.out.println(book1.getBookId());
			//System.out.println(book1.getBookName());
			
			/*
			ObjectMapper mapper = new ObjectMapper();
			StringWriter stringWriter = new StringWriter();
			
			mapper.writeValue(stringWriter,book1);
			System.out.println("writing value");
			System.out.println(stringWriter.toString());
			*/
			
			String url = "http://localhost:8080/restApp/restDemo/list";
			//List<Book> bookList = (List<Book>) restTemplate.getForObject(url,Book.class);
			
			String response = restTemplate.getForObject(url,String.class);
			System.out.println(response);
			/*
			System.out.println(bookList);
			
			
			for(Book book:bookList){
				System.out.println(book.getBookName());
				System.out.println("nextBook");
			}
			*/
			
			
		}
		
	    /*    
	        Map<String,Integer> vars = new HashMap<String,Integer>();
	        vars.put("bookId",1);

	        
	        try
	        {
	            RestTemplate restTemplate = new RestTemplate();
	            
	            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
	            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

	            String uri = "http://localhost:8080/restApp/restDemo/book/1";
	            Book book = restTemplate.getForObject(uri,Book.class);

	            LOGGER.debug("Book:  " + book.getBookName());
	            System.out.println("received book");
	            System.out.println(book.getBookId());
	            System.out.println(book.getBookName());

	        }
	      */  
	        catch (HttpClientErrorException e)
	        {
	            LOGGER.error("error:  " + e.getResponseBodyAsString());
	        	e.printStackTrace();
	        }
	        catch(Exception e)
	        {
	            LOGGER.error("error:  " + e.getMessage());
	            e.printStackTrace();
	        }
	        
	     
	   }
}
