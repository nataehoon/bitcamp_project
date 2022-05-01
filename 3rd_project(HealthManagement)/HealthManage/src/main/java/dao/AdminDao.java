package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Combo01;
import bean.Diet;
import bean.Health;
import bean.Log;
import bean.Posture;

@Component("addao")
public class AdminDao {
	private final String namespace = "MapperAdmin.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public List<Posture> SelectPoData(String id) {
		return this.asdf.selectList(namespace + "SelectPoData", id);
	}

	public List<Health> SelectHealthData(String id) {
		return this.asdf.selectList(namespace + "SelectHealthData", id);
	}

	public List<Diet> SelectDietData(String id) {
		return this.asdf.selectList(namespace + "SelectDietData", id);
	}

	public List<Log> SelectLogData(String id) {
		return this.asdf.selectList(namespace + "SelectLogData", id);
	}

	public List<Combo01> SelectPoMeData(int offset, int limit, String mode, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectList(namespace + "SelectPoMeData", map, rowBounds);
	}

	public List<Combo01> SelectHealthMeData(int offset, int limit, String mode, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectList(namespace + "SelectHealthMeData", map, rowBounds);
	}

	public List<Combo01> SelectDietMeData(int offset, int limit, String mode, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectList(namespace + "SelectDietMeData", map, rowBounds);
	}

	public List<Combo01> SelectLogMeData(int offset, int limit, String mode, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectList(namespace + "SelectLogMeData", map, rowBounds);
	}


	public int SelectTotalPoCount(String mode, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectOne(namespace + "SelectTotalPoCount", map);
	}

	public int SelectTotalHealthCount(String mode, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectOne(namespace + "SelectTotalHealthCount", map);
	}

	public int SelectTotalDietCount(String mode, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectOne(namespace + "SelectTotalDietCount", map);
	}

	public int SelectTotalLogCount(String mode, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectOne(namespace + "SelectTotalLogCount", map);
	}

	public int SelectTotalCountByPoPk(String id) {
		return this.asdf.selectOne(namespace + "SelectTotalCountByPoPk", id);
	}

	public int SelectTotalCountByHealthPk(String id) {
		return this.asdf.selectOne(namespace + "SelectTotalCountByHealthPk", id);
	}

	public int SelectTotalCountByDietPk(String id) {
		return this.asdf.selectOne(namespace + "SelectTotalCountByDietPk", id);
	}

	public int SelectTotalCountByLogPk(String id) {
		return this.asdf.selectOne(namespace + "SelectTotalCountByLogPk", id);
	}

}
