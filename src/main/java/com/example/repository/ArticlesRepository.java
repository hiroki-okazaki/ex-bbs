package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Article;

/**
 * articlesテーブルを操作するリポジトリ.
 * 
 * @author hirokiokazaki
 *
 */
@Repository
public class ArticlesRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, i) -> {
		// ここに結果の処理を書く
		Article article = new Article();

		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));

		return article;
	};

	/**
	 * 全投稿記事を取得.
	 * 
	 * @return 投稿記事情報
	 */
	public List<Article> findAll() {
		String sql = "SELECT id,name,content FROM articles ORDER BY id DESC";

		List<Article> article = template.query(sql, ARTICLE_ROW_MAPPER);

		return article;
	}

	/**
	 * 掲示板に記事を投稿する. IDが
	 * 
	 * @param article 投稿記事
	 * @return 投稿記事情報
	 */
	public Article insert(Article article) {
		System.out.println(article);
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);
		
			String insertSql = "INSERT INTO articles (name, content) VALUES(:name, :content)";

			template.update(insertSql, param);

		return article;
	}
	
	public void deleteById(Integer id) {
		String deleteSql = "DELETE FROM articles WHERE id = :id ";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		template.update(deleteSql, param);
	}
}
