package com.tendy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
	@Autowired
	private NewsRepo repository;
	
	public List<News> getAll(){
		return repository.findAll();
	}
	
	public void save(News news) {
		repository.save(news);
	}
	
	public News getNews(String id) {
		return repository.findById(id).get();
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
}
