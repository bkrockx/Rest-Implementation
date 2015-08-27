package controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import model.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.*;
import service.*;

@Controller
@RequestMapping(value="/rest")
public class RestChapterController {
	
	@Autowired
	ChapterService chapterService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	ChapterDao chapterDao;
	
	@Autowired
	BookDao bookDao;
	
	static final Logger logger = Logger.getLogger(ChapterController.class);
	
	// to get list of chapters
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Chapter> getRecords(){
		List<Chapter> chapterList = null;
		try{
			chapterList = chapterService.getAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("chapterList returned");
		System.out.println(chapterList);
		return chapterList;
	}
	
	// to get all the chapters associated with a particular book
	@RequestMapping(value = "/list/{bookId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Chapter> getChapterRecord(@PathVariable("bookId")Integer bookId){
		List<Chapter> chapterList = null;
		try{
			System.out.println("getting the list of chapters contained in book");
			chapterList = chapterService.getAll(bookId);
			System.out.println("list of chapters obtained");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("chapterList returned");
		System.out.println(chapterList);
		return chapterList;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// to add chapter without specifying book
	/*
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public @ResponseBody 
	Status getAdd(@RequestBody Chapter chapter){
		try{
			chapterService.addChapter(chapter);
			return new Status(1,"chapter added successfully");
		}catch(Exception e){
			return new Status(0, e.toString());
		}
	}
	*/
	
	// to add chapter to a particular book
	/*
	 
	@RequestMapping(value="/add/bookId/{chapterName}", method = RequestMethod.POST)
	public @ResponseBody 
	Status postAdd(@PathVariable("bookId")Integer bookId,@PathVariable("chapterName")String chapterName) throws IOException{
		try{
			Chapter chapter = chapterService.getChapterByName(chapterName);
			chapterService.add(bookId, chapter);
			return new Status(1,"chapter added successfully");
		}catch(Exception e){
			return new Status(0,e.toString());
		}
	}
	
	*/
	
	// to add chapter to a particular book
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String getAdd(@RequestParam("id")Integer bookId,Model model){
		
		model.addAttribute("bookId",bookId);
		Chapter chapter = new Chapter();
		model.addAttribute("chapterAttribute",chapter);
		
		return "addChapter";
	}
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String postAdd(@RequestParam("id")Integer bookId,@ModelAttribute("chapterAttribute")Chapter chapter) throws Exception{
		System.out.println("inside postAdd");
		chapterService.add(bookId, chapter);
		System.out.println("performed postAdd");
		return "redirect:/book/hello";
	}
	
	// to delete a particular chapter
	@RequestMapping(value = "/delete/{chapterId}", method = RequestMethod.GET)
	public @ResponseBody 
	Status deleteEmployee(@PathVariable("chapterId")Integer chapterId) {
		try {
			chapterService.deleteChapter(chapterId);
			return new Status(1, "book deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
		//return "redirect:/project3/list";
	}
   
}
