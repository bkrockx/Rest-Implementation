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


public class RestClientPostCall {
		
	public static final Logger LOGGER =  getLogger(RestClientPostCall.class);
	
	public static void main(String[] args){
		
		LOGGER.debug("starting post restclient services");
		try{
			Book book = new Book();
			book.setBookName("geo11");
			
			RestTemplate rst = new RestTemplate();
			
			rst.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			rst.getMessageConverters().add(new StringHttpMessageConverter());
			
			String url = "http://localhost:8080/restApp/restDemo/add";
			System.out.println("testing 1");
			
			//String response = rst.postForObject(url,book,String.class);
			
			Book book1 = rst.postForObject(url,book,Book.class);
			
			System.out.println(book1.getBookId()+" "+book1.getBookName());
			
		}
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
