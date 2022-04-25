package kids.board.re_home.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.members.parents.model.ParentsMiniView;
import kids.members.student.model.Student;

public class Re_homeDao extends SuperDao {

	public List<Re_home> selectDataList(String status, List<ParentsMiniView> plists) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		List<Re_home> lists = new ArrayList<Re_home>() ;
		
		String sql = "select * from re_home where status = ? and " ;

		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
		//	pstmt.setInt(1, class_id);
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) {
				Student bean = new Student() ; 
			
			bean.setSid(rs.getInt("sid"));
			bean.setAddress1(rs.getString("address1"));
			bean.setAddress2(rs.getString("address2"));
			bean.setBirth(rs.getString("birth"));
			bean.setGender(rs.getString("gender"));
			bean.setHp(rs.getString("hp"));
			bean.setImage(rs.getString("image"));
			bean.setName(rs.getString("name"));
			bean.setClass_id(rs.getInt("class_id"));
			bean.setZipcode(rs.getString("zipcode"));
			//	lists.add( bean ) ; 
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				this.closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return lists  ;
	}

}
