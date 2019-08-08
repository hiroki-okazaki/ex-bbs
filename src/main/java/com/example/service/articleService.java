package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.repository.ArticlesRepository;


@Service
@Transactional
public class articleService {

	@Autowired
	private ArticlesRepository articleRepository;
	
	

	
	public void insert(Article article) {
		articleRepository.insert(article);
	}
	
	public List<Article> findAll() {
		List<Article> articleList = articleRepository.findAll();
		return articleList;
	}
}
