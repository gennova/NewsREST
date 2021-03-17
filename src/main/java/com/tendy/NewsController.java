package com.tendy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
public class NewsController {

	@Autowired
	private NewsService service;
	
	@GetMapping("/news")
	public List<News> list(){
		return service.getAll();
	}
	
	@GetMapping("/news/{id}")
	public ResponseEntity<News> get(@PathVariable String id) {
		try {
			News news = service.getNews(id);
			return new ResponseEntity<News>(news,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/news")
	public void add(@RequestBody News news) {
		service.save(news);
	}
	
	@PutMapping("/news/{id}")
	public ResponseEntity<?> update(@RequestBody News news,@PathVariable String id) {
		try {
			News old = service.getNews(id);
			service.save(news);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("news/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}
}
