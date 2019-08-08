package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.form.articleForm;
import com.example.form.commentForm;
import com.example.service.articleService;
import com.example.service.commentService;

@Controller
@RequestMapping("/article")
public class articleController {
	
	@Autowired
	private articleService articleService;
	
	@Autowired
	private commentService commentService;
	
	
	@ModelAttribute
	public articleForm setUparticleForm() {
		return new articleForm();
	}
	
	@ModelAttribute
	public commentForm setUpcommentForm() {
		return new commentForm();
	}

	@RequestMapping("/articleList")
	public String articleList(Model model) {
		model.addAttribute("articleList",articleService.findAll());
		model.addAttribute("commentList",commentService.findAll());
		
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
	
	
	@RequestMapping("/insertComment")
	public String insertComment(commentForm form) {
		Comment comment = new Comment();
		
		comment.setName(form.getName());
		comment.setContent(form.getContent());
		
		commentService.insert(comment);
		return "redirect:/article/articleList";
	}
	
}
