package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Log;

@Component("lodao")
public class ExerciseLogDao {
	private final String namspace = "MapperExerciseLog.";
	
	@Autowired
	SqlSessionTemplate asdf;
	
	public ExerciseLogDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Log> SelectData(String id) {
		return this.asdf.selectList(namspace + "SelectDataList", id);
	}

	public int InsertData(Log xxx) {
		return this.asdf.insert(namspace + "InsertData", xxx);
	}

	public Log selectByPk(int logno) {
		return this.asdf.selectOne(namspace + "SelectByPk", logno);
	}

	public int UpdateData(Log xxx) {
		return this.asdf.update(namspace + "UpdateData", xxx);
	}

	public int DeleteData(int logno) {
		return this.asdf.delete(namspace + "DeleteData", logno);
	}

}
