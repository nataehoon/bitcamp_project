package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Noticeboard;

@Component("ndao")
public class NoticeboardDao {
	private final String namespace = "MapperNotice.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public List<Noticeboard> SelectData(int offset, int limit, String mode, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%" + keyword + "%");
		return this.asdf.selectList(namespace + "SelectDataList", map, rowBounds);
	}

	public int SelectTotalCount(String mode, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%" + keyword + "%");
		return this.asdf.selectOne(namespace + "SelectTotalCount", map);
	}

	public Noticeboard SelectByPk(int notino) {
		return this.asdf.selectOne(namespace + "SelectByPk", notino);
	}

	public int DeleteData(int notino) {
		return this.asdf.delete(namespace + "DeleteData", notino);
	}

	public int InsertData(Noticeboard xxx) {
		return this.asdf.insert(namespace + "InsertData", xxx);
	}

	public int UpdateData(Noticeboard xxx) {
		return this.asdf.update(namespace + "UpdateData", xxx);
	}

	

}
