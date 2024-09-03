package com.sana.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sana.models.News;
import com.sana.service.NewsService;

@RestController
public class NewsApi {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/news")
	public List<News> getallNews(){
		return newsService.getallNewsbyTime();
	}

}
