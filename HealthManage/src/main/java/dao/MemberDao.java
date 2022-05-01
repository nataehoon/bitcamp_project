package dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Health;
import bean.Member;

@Component("mdao")
public class MemberDao {
	private final String namespace = "MapperMember.";
	
	@Autowired
	SqlSessionTemplate asdf;
	
	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Member SelectData(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		return this.asdf.selectOne(namespace + "SelectData", map);
	}

	public int InsertData(Member bean) {
		return this.asdf.insert(namespace + "InsertData", bean);
	}

	public Member SelectByPk(String id) {
		return this.asdf.selectOne(namespace + "SelectByPk", id);
	}

	public Member SelectByNickname(String nickname) {
		return this.asdf.selectOne(namespace + "SelectByNickname", nickname);
	}

	public int UpdateProfile(Member bean) {
		return this.asdf.update(namespace + "UpdateProfile", bean);
	}

	public int UpdateData(Member xxx) {
		return this.asdf.update(namespace + "UpdateData", xxx);
	}

	public int UpdateProData(Member xxx) {
		return this.asdf.update(namespace + "UpdateProData", xxx);
	}

}
