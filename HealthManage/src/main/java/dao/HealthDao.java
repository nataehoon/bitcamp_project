package dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Health;
import bean.Member;

@Component("hdao")
public class HealthDao {
private final String namspace = "MapperHealthChart.";
	
	@Autowired
	SqlSessionTemplate asdf;
	
	public HealthDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Health> SelectData(String id, int offset, int limit) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return this.asdf.selectList(namspace + "SelectDataList", id, rowBounds);
	}

	public int InsertData(Health xxx) {
		return this.asdf.insert(namspace + "InsertData", xxx);
	}

	public int UpdateData(Health xxx) {
		return this.asdf.update(namspace + "UpdateData", xxx);
	}

	public int DeleteData(int healthno) {
		return this.asdf.delete(namspace + "DeleteData", healthno);
	}

	public Health SelectByPk1(String id) {
		return this.asdf.selectOne(namspace + "SelectByPk1", id);
	}

	public Health SelectByPk2(String id) {
		return this.asdf.selectOne(namspace + "SelectByPk2", id);
	}

	public int SelectTotalCount(String id) {
		return this.asdf.selectOne(namspace + "SelectTotalCount", id);
	}

	public Health SelectByPk(int healthno) {
		return this.asdf.selectOne(namspace + "SelectByPk", healthno);
	}

	public Member SelectById(String id) {
		return this.asdf.selectOne(namspace + "SelectById", id);
	}
}
