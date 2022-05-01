package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Health;
import bean.Posture;

@Component("adao")
public class AdviceboardDao {
	private String namespace = "MapperAdvice.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public Health SelectHData(String id) {
		return this.asdf.selectOne(namespace + "SelectHData", id);
	}

	public Posture SelectPData(String id) {
		return this.asdf.selectOne(namespace + "SelectPData", id);
	}

}
