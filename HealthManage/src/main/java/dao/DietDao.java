package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Diet;
import bean.Log;

@Component("ddao")
public class DietDao {
	private final String namespace = "MapperDiet.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public List<Diet> SelectData(String id) {
		return this.asdf.selectList(namespace + "SelectDataList", id);
	}

	public int InsertData(Diet xxx) {
		return this.asdf.insert(namespace + "InsertData", xxx);
	}

	public Diet selectByPk(int dietno) {
		return this.asdf.selectOne(namespace + "SelectByPk", dietno);
	}

	public int UpdateData(Diet xxx) {
		return this.asdf.update(namespace + "UpdateData", xxx);
	}

	public int DeleteData(int dietno) {
		return this.asdf.delete(namespace + "DeleteData", dietno);
	}

}
