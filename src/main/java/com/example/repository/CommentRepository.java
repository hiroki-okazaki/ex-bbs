package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

@Repository
public class CommentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
		// ここに結果の処理を書く
		Comment comment = new Comment();

		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));

		return comment;
	};

	/**
	 * 全投稿記事を取得.
	 * 
	 * @return 投稿記事情報
	 */
	public List<Comment> findAll() {
		String sql = "SELECT id,name,content,article_id FROM comments ORDER BY id DESC";

		List<Comment> comment = template.query(sql, COMMENT_ROW_MAPPER);

		return comment;
	}

	/**
	 * 掲示板に記事を投稿する. IDが
	 * 
	 * @param article 投稿記事
	 * @return 投稿記事情報
	 */
	public Comment insert(Comment comment) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);

		String insertSql = "INSERT INTO comments (name, content,article_id) VALUES(:name, :content, :articleId)";

		template.update(insertSql, param);

		return comment;
	}
}