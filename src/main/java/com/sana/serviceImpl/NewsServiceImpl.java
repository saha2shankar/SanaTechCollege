package com.sana.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.News;
import com.sana.repository.NewsRepository;
import com.sana.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsRepository repo;

	@Override
	public void addNews(News news) {
		repo.save(news);
		
	}

	@Override
	public void deteteNews(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateNews(News news) {
		repo.save(news);
		
	}

	@Override
	public News getNewsbyid(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<News> getallNewsbyTime() {
		List<News> News = repo.findAll();
		List<News> sortedNews = News.stream().sorted((n1,n2) ->
		n2.getPosttime().compareTo(n1.getPosttime())).collect(Collectors.toList());

		return sortedNews;
	}

}
