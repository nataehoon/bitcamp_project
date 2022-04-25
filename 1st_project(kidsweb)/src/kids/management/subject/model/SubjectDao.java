package kids.management.subject.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.management.myclass.model.Myclass;
import kids.members.student.model.Student;

public class SubjectDao extends SuperDao{

	 public int DeleteData(int subject_code) {
		 String sql ;		
			PreparedStatement pstmt = null ;		
			Student bean = null ;
			int cnt = -99999 ;
			try {
				bean = this.SelectDataByPk(subject_code) ;
				
				if( conn == null ){ super.conn = super.getConnection() ; }
				conn.setAutoCommit( false );
				
//				sql = " update employees set remark = ?  " ;
//				sql += " where subject_code = ? " ;
//				pstmt = super.conn.prepareStatement(sql) ;
//				
				String imsi = bean.getName() +  "(" + subject_code + ")가 과목코드가 삭제 되었습니다." ;
//				pstmt.setString(1, imsi);			
//				pstmt.setInt(2, subject_code);
//				
//				cnt = pstmt.executeUpdate() ;
				if(pstmt != null) {pstmt.close();}
				
				sql = " update activity set remark = ?  " ;
				sql += " where subject_code = ? " ;
				pstmt = super.conn.prepareStatement(sql) ;
				
				
				pstmt.setString(1, imsi);			
				pstmt.setInt(2, subject_code);
				
				cnt = pstmt.executeUpdate() ;
				if(pstmt != null) {pstmt.close();}
				
				sql = " delete from subject " ;
				sql += " where subject_code = ? " ;
				pstmt = super.conn.prepareStatement(sql) ;
				pstmt.setInt(1, subject_code);			
				cnt = pstmt.executeUpdate() ;
				if(pstmt != null) {pstmt.close();}
				
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
			return cnt;
	}

	private Student SelectDataByPk(int subject_code) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		
		String sql = " select * from subject " ;
		sql += " where subject_code = ? " ;
		
		Student bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setInt(1, subject_code);
			
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				Subject sbean = new Subject();
				
				sbean.setSubject_code(rs.getInt("subject_code"));
				sbean.setSubject(rs.getString("subject"));
				sbean.setRemark(rs.getString("remark"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null ){ rs.close(); }
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		
		return bean ;
	}

	public int InsertData(Subject bean) {
		String sql = "insert into subject(subject_code, subject)"
				+ " values(?, ?)" ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ; 
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bean.getSubject_code());
			pstmt.setString(2, bean.getSubject());
		
			cnt = pstmt.executeUpdate() ; 
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
		return cnt ;
	}


	public List<Subject> SelectDataList() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from subject " ;
		
		List<Subject> lists = new ArrayList<Subject>() ;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			
			rs = pstmt.executeQuery() ;
			
			while (rs.next()) {
				Subject bean = new Subject();
				
				bean.setRemark(rs.getString("remark"));
				bean.setSubject(rs.getString("subject"));
				bean.setSubject_code(rs.getInt("subject_code"));
			
				lists.add(bean);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null ){ rs.close(); }
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return lists;
	}
	
	public int UpdateData( Subject bean ){
		String sql = " Update Subject set subject_code = ?, subject = ?, remark = ? " ; 
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bean.getSubject_code());
			pstmt.setString(2, bean.getSubject());
			
			cnt = pstmt.executeUpdate() ; 
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
		
		return cnt;
		
		
	}

}
