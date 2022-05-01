package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Board;
import bean.Comment;
import bean.Noticeboard;

@Component("bdao")
public class BoardDao {
	private final String namespace = "MapperBoard.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public List<Board> SelectData(String category, int offset, int limit, String mode, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectList(namespace + "SelectDataList", map, rowBounds);
	}

	public int InsertData(Board xxx) {
		return this.asdf.insert(namespace + "InsertData", xxx);
	}

	public Board SelectByPk(int bono) {
		return this.asdf.selectOne(namespace + "SelectByPk", bono);
	}

	public int DeleteData(int bono) {
		return this.asdf.delete(namespace + "DeleteData", bono);
	}

	public int UpdateData(Board xxx) {
		return this.asdf.update(namespace + "UpdateData", xxx);
	}

	public int SelectTotalCount(String mode, String keyword, String category) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectOne(namespace + "SelectTotalCount", map);
	}

	public int InsertCoData(Comment xxx) {
		return this.asdf.insert(namespace + "InsertCoData", xxx);
	}

	public List<Comment> SelectCoData(int bono, int offset, int limit) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return this.asdf.selectList(namespace + "SelectCoData", bono, rowBounds);
	}

	public int SelectTotalCoCount(int bono) {
		return this.asdf.selectOne(namespace + "SelectTotalCoCount", bono);
	}

	public Comment SelectByCo(int cono) {
		return this.asdf.selectOne(namespace + "SelectByCo", cono);
	}

	public int DeleteCo(int cono) {
		return this.asdf.delete(namespace + "DeleteCo", cono);
	}

	public int UpdateCoData(Comment xxx) {
		return this.asdf.update(namespace + "UpdateCoData", xxx);
	}

	public List<Board> SelectBoData() {
		return this.asdf.selectList(namespace + "SelectBoData");
	}

	public List<Noticeboard> SelectNoData() {
		return this.asdf.selectList(namespace + "SelectNoData");
	}

	public int UpdateReadhit(int bono) {
		return this.asdf.delete(namespace + "UpdateReadhit", bono);
	}

	public int UpdateRecommend(int bono) {
		return this.asdf.update(namespace + "UpdateRecommend", bono);
	}

}
