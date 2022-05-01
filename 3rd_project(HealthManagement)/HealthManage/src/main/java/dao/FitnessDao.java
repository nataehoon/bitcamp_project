package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Fitness;

@Component("fdao")
public class FitnessDao {
	private final String namespace = "MapperFitness.";
	
	@Autowired
	SqlSessionTemplate asdf;

	public List<Fitness> SelectData(String gu) {
		return this.asdf.selectList(namespace + "SelectDataList", gu);
	}

	public Fitness SelectByPk(int fitno) {
		return this.asdf.selectOne(namespace + "SelectByPk", fitno);
	}

}
