package service;

import dao.*;
import model.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	ChapterDao chapterDao;
	
	public List<Chapter> getAll(Integer bookId) throws Exception {
		return chapterDao.getAll(bookId);
	}

	public List<Chapter> getAll() throws Exception {
		return chapterDao.getAll();
	}

	public Chapter get(Integer chapterId) throws Exception {
		return chapterDao.get(chapterId);
	}

	public Chapter getChapterByName(String chapterName) throws Exception {
		return chapterDao.getChapterByName(chapterName);
	}

	public void add(Integer bookId, Chapter chapter) throws Exception {
		chapterDao.add(bookId, chapter);
	}

	public void addChapter(Chapter chapter) throws Exception {
		chapterDao.addChapter(chapter);
	}

	public void edit(Chapter chapter) throws Exception {
		chapterDao.edit(chapter);
	}

	public void deleteChapter(Integer chapterId) throws Exception {
		chapterDao.deleteChapter(chapterId);
	}

}
