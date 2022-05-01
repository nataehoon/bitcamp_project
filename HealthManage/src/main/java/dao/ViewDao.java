package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Diet;
import bean.Health;
import bean.Log;
import bean.Member;
import bean.Posture;

@Component("vdao")
public class ViewDao {
	private final String namespace = "MapperView.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public List<Health> SelectHealthData(String id) {
		return this.asdf.selectList(namespace + "SelectHealthData", id);
	}

	public List<Posture> SelectPostureData(String id) {
		return this.asdf.selectList(namespace + "SelectPostureData", id);
	}

	public List<Log> SelectLogData(String id) {
		return this.asdf.selectList(namespace + "SelectLogData", id);
	}

	public List<Diet> SelectDietData(String id) {
		return this.asdf.selectList(namespace + "SelectDietData", id);
	}

	public Health SelectByPkHealth(String id) {
		return this.asdf.selectOne(namespace + "SelectByPkHealth", id);
	}

	public Posture SelectByPkPosture(String id) {
		return this.asdf.selectOne(namespace + "SelectByPkPosture", id);
	}

	public int SelectTotalHealthCount(String id) {
		return this.asdf.selectOne(namespace + "SelectTotalHealthCount", id);
	}

	public int SelectTotalPostureCount(String id) {
		return this.asdf.selectOne(namespace + "SelectTotalPostureCount", id);
	}

	public List<Member> SelectData(int offset, int limit, String mode, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectList(namespace + "SelectData", map, rowBounds);
	}

	public int SelectTotalCount(String mode, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mode", mode);
		map.put("keyword", "%"+ keyword + "%");
		return this.asdf.selectOne(namespace + "SelectTotalCount", map);
	}

	public Member SelectByPk(String id) {
		return this.asdf.selectOne(namespace + "SelectByPk", id);
	}

}
