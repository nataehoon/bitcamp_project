package kids.board.notice_board.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.management.myclass.model.Myclass;
import kids.members.employees.model.Employees;

public class Notice_boardDao extends SuperDao {

	public int selectNoticeCount(String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select count(*) as cnt from notice_board " ;
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
		
		int cnt = 0 ; //없는 경우의 기본 값
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			 
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				cnt = rs.getInt("cnt");
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
		return cnt  ; 
	}

	public List<Notice_board> SelectList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, notino, tid, content, files, title, class_id, regdate, readhit, remark, class_name as class_name from ( "
				+ " select b.*, c.class_name, rank() over(order by notino desc) "
				+ " as ranking from notice_board b inner join myclass c "
				+ " on b.class_id = c.class_id ";
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
		sql += " ) where ranking between ? and ? ";
		
		List<Notice_board> lists = new ArrayList<Notice_board>();
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) { 
				Notice_board bean = new Notice_board();
				
				bean.setContent(rs.getString("content"));
				bean.setFiles(rs.getString("files"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setRemark(rs.getString("remark"));
				bean.setTid(rs.getString("tid"));
				bean.setNotino(rs.getInt("notino"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setTitle(rs.getString("title"));
				bean.setClass_name(rs.getString("class_name"));
				
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
		return lists  ; 
	}

	public int InsertData(Notice_board bean) {
PreparedStatement pstmt = null;
		
		String sql = " insert into notice_board(notino, tid, title, content, files, regdate, class_id, readhit, remark) ";
			sql += " values(notino_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?) ";
		
		int cnt = -99999;
		System.out.println(bean);
		try {
			if( conn == null ) { super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getTid());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getFiles());
			pstmt.setInt(5, bean.getClass_id());
			pstmt.setInt(6, bean.getReadhit());
			pstmt.setString(7, bean.getRemark());
			
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
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}

	public Notice_board DetailGoData(int notino) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from notice_board where notino = ? ";
		
		Notice_board bean = null;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			pstmt.setInt(1, notino);
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) { 
				bean = new Notice_board();
				
				bean.setContent(rs.getString("content"));
				bean.setFiles(rs.getString("files"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setRemark(rs.getString("remark"));
				bean.setTid(rs.getString("tid"));
				bean.setNotino(rs.getInt("notino"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setTitle(rs.getString("title"));
				
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
		return bean  ; 
	}

	public int DeleteNotiData(int notino) {
		String sql = " delete from notice_board where notino = ? ";
		PreparedStatement pstmt = null;
		int cnt = -99999;
		
		try {
			if(conn == null ) {super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, notino);
			
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

	public int UpdateNotiData(Notice_board bean) {
		PreparedStatement pstmt = null;
		String sql = " update notice_board set tid = ?, title = ?, content = ?, files = ?, regdate = sysdate, class_id = ? ";
			sql += " where notino = ? ";
		
		int cnt = -99999;
		System.out.println(bean);
		try {
			if( conn == null ) { super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getTid());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getFiles());
			pstmt.setInt(5, bean.getClass_id());
			pstmt.setInt(6, bean.getNotino());
			
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
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}

	public int UpdateReadhit(int notino) {
		PreparedStatement pstmt = null ;
		
		String sql = " update notice_board set readhit = readhit + 1 " ;
		sql += " where notino = ? " ;
		
		int cnt = -99999 ; 
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			conn.setAutoCommit( false ); 
			pstmt = this.conn.prepareStatement( sql ) ;
			
			pstmt.setInt(1, notino);
			
			cnt = pstmt.executeUpdate() ;
			conn.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			cnt = -99999 ;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return cnt ; 
	}

}
