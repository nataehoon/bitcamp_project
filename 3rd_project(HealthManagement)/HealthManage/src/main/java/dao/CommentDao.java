package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Comment;

@Component
public class CommentDao {
	private final String namespace = "MapperComment.";
	
	@Autowired
	SqlSessionTemplate asdf;
	
	public List<Comment> SelectCommentList(int bono) {
		return this.asdf.selectList(namespace + "SelectCommentList", bono);
	}

}
