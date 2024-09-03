package com.sana.service;

import java.util.List;

import com.sana.models.News;

public interface NewsService {

	
	void addNews(News news);
	void deteteNews(int id);
	void updateNews(News news);
	News getNewsbyid(int id);
	List<News> getallNewsbyTime();
}
