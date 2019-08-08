package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.articleForm;
import com.example.service.articleService;

@Controller
@RequestMapping("/article")
public class articleController {
	
	@Autowired
	private articleService articleService;
	
	
	@ModelAttribute
	public articleForm setUparticleForm() {
		return new articleForm();
	}

	@RequestMapping("/articleList")
	public String articleList(Model model) {
		model.addAttribute("articleList",articleService.findAll());
		return "/article/articleContent";
	}
	
	@RequestMapping("/insert")
	public String insert(articleForm form) {
		Article article = new Article();
		
		article.setName(form.getName());
		article.setContent(form.getContent());
		articleService.insert(article);
		return "redirect:/article/articleList";
	}
	
}
