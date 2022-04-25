package kids.board.diet.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.members.employees.model.Employees;

public class DietDao extends SuperDao {

	public List<Diet> SelectDietData() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from diet order by to_char(regdate,'yyyy/mm/dd') desc, category asc ";
		
		List<Diet> lists = new ArrayList<Diet>();
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) { 
				Diet bean = new Diet();
				
				String str2 = rs.getString("category");
				bean.setCategory(str2.substring(1));
				bean.setContent(rs.getString("content"));
				bean.setDietno(rs.getInt("dietno"));
				bean.setFiles(rs.getString("files"));
				String str = rs.getString("regdate");
				bean.setRegdate(str.substring(0, 10));
				bean.setRemark(rs.getString("remark"));
				
				lists.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		System.out.println(lists.size());
		return lists  ; 
	}

	public int InsertDietDate(Diet bean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " insert into diet(dietno, regdate, category, files, content) ";
		sql += " values(diet_seq.nextval, sysdate, ?, ?, ?) ";
		
		int cnt = -99999;
		try {
			if( this.conn == null) {this.conn = this.getConnection();}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getCategory());
			pstmt.setString(2, bean.getFiles());
			pstmt.setString(3, bean.getContent());
			
			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}

	public Diet DetailDate(int dietno) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from diet where dietno = ? ";
		
		Diet bean = null;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			pstmt.setInt(1, dietno);
			
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) { 
				bean = new Diet();
				
				String str=rs.getString("regdate");
				String str2 = rs.getString("category");
				bean.setCategory(str2.substring(1));
				bean.setContent(rs.getString("content"));
				bean.setDietno(rs.getInt("dietno"));
				bean.setFiles(rs.getString("files"));
				bean.setRegdate(str.substring(0, 10));
				bean.setRemark(rs.getString("remark"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return bean; 
	}

	public int DeleteDietData(int dietno) {
		String sql = " delete from diet where dietno = ? ";
		PreparedStatement pstmt = null;
		int cnt = -99999;
		
		try {
			if(conn == null ) {super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, dietno);
			
			cnt = pstmt.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 		
		return cnt  ; 
	}

	public int UpdateDietDate(Diet bean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " update diet set regdate = sysdate, category = ?, files = ?, content = ? ";
		sql += " where dietno = ? ";
				
		int cnt = -99999;
		try {
			if( this.conn == null) {this.conn = this.getConnection();}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getCategory());
			pstmt.setString(2, bean.getFiles());
			pstmt.setString(3, bean.getContent());
			pstmt.setInt(4, bean.getDietno());
			
			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
}