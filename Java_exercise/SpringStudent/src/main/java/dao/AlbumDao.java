package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Album;
import bean.CheckBean;
import utility.Paging;

@Component("dao")
public class AlbumDao {
	private final String namespace = "MyAlbum";
	
	@Autowired
	SqlSessionTemplate abcd;
	
	//앨범 등록하기
	public void insert(Album album) {
		System.out.println(this.getClass() + "insert() 메소드 들어옴");
		this.abcd.insert(namespace + ".insert", album);
	}
	
	public int GetTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt = this.abcd.selectOne(namespace + ".getTotalCount", map);
		return cnt;
	}
	
	public List<Album> GetAlbumList(Paging pageInfo, Map<String, String> map){
		List<Album> lists = null;
		RowBounds rewBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = this.abcd.selectList(namespace + ".getAlbumList", map, rewBounds);
		return lists;
	}
	
	public List<CheckBean> GetList(String module, String field){
		Map<String, String> map = new HashMap<String, String>();
		map.put("module", module);
		map.put("field", field);
		
		return this.abcd.selectList(namespace + ".GetList", map);
		
	}
}
