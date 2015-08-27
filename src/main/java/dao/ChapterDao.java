package dao;

import java.util.*;

import model.Chapter;

public interface ChapterDao {
	
	public List<Chapter> getAll(Integer bookId) throws Exception;
	
	public List<Chapter> getAll() throws Exception;
	
	public Chapter get(Integer chapterId) throws Exception;
	
	public Chapter getChapterByName(String chapterName) throws Exception;
	
	public void add(Integer bookId,Chapter chapter) throws Exception;
	
	public void addChapter(Chapter chapter) throws Exception;
	
	public void edit(Chapter chapter) throws Exception;
	
	public void deleteChapter(Integer chapterId) throws Exception; 

}
