package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Log;
import bean.Posture;

@Component("pdao")
public class PostureDao {
	private final String namspace = "MapperPosture.";
	
	@Autowired
	SqlSessionTemplate asdf;
	
	public PostureDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Posture> SelectData(String id) {
		return this.asdf.selectList(namspace + "SelectDataList", id);
	}

	public int InsertData(Posture xxx) {
		return this.asdf.insert(namspace + "InsertData", xxx);
	}

	public int UpdateData(Posture xxx) {
		return this.asdf.update(namspace + "UpdateData", xxx);
	}

	public int DeleteData(int pono) {
		return this.asdf.delete(namspace + "DeleteData", pono);
	}

	public Posture SelectPk(int pono) {
		return this.asdf.selectOne(namspace + "SelectPk", pono);
	}

	public Posture SelectByPk1(String id) {
		return this.asdf.selectOne(namspace + "SelectByPk1", id);
	}
	
	public Posture SelectByPk2(String id) {
		return this.asdf.selectOne(namspace + "SelectByPk2", id);
	}

	public int SelectTotalCount(String id) {
		return this.asdf.selectOne(namspace + "SelectTotalCount", id);
	}

}
