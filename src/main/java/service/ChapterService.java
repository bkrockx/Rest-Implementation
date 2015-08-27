package service;

import java.util.*;

import model.Chapter;
import dao.*;

public interface ChapterService {
	
	public List<Chapter> getAll(Integer bookId) throws Exception;
	
	public List<Chapter> getAll() throws Exception;
	
	public Chapter get(Integer chapterId) throws Exception;
	
	public Chapter getChapterByName(String chapterName) throws Exception;
	
	public void add(Integer bookId,Chapter chapter) throws Exception;
	
	public void addChapter(Chapter chapter) throws Exception;
	
	public void edit(Chapter chapter) throws Exception;
	
	public void deleteChapter(Integer chapterId) throws Exception; 

}
