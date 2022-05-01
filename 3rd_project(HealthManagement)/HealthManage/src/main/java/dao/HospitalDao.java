package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Fitness;
import bean.Hospital;

@Component("hodao")
public class HospitalDao {
	private final String namespace = "MapperHospital.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public List<Hospital> SelectData(String gu) {
		return this.asdf.selectList(namespace + "SelectDataList", gu);
	}

	public Hospital SelectByPk(int hono) {
		return this.asdf.selectOne(namespace + "SelectByPk", hono);
	}

}
