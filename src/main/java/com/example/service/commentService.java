package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Comment;
import com.example.repository.CommentRepository;

@Service
@Transactional
public class commentService {

	@Autowired
	private CommentRepository commentRepository;

	public void insert(Comment comment) {
		commentRepository.insert(comment);
	}

	public List<Comment> findAll() {
		List<Comment> commentList = commentRepository.findAll();
		return commentList;
	}
}
