package kids.board.timetable.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.controller.SuperClass;
import kids.common.model.SuperDao;
import kids.management.myclass.model.Myclass;
import kids.members.student.model.Student;

public class TimetableDao extends SuperDao{
	

	public int DeleteData(int time_id) {
		String sql ;		
		PreparedStatement pstmt = null ;		
		Student bean = null ;
		int cnt = -99999 ;
		try {
			bean = this.SelectDataByPk(time_id) ;
			
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			sql = " update subject set remark = ?  " ;
			sql += " where time_id = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			String imsi = bean.getName() +  "(" + time_id + ")가 시간아이디가 삭제 되었습니다." ;
			pstmt.setString(1, imsi);			
			pstmt.setInt(2, time_id);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			sql = " update myclass set remark = ?  " ;
			sql += " where time_id = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			
			pstmt.setString(1, imsi);			
			pstmt.setInt(2, time_id);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			sql = " delete from timetable " ;
			sql += " where time_id = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, time_id);			
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

	private Student SelectDataByPk(int time_id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		
		String sql = " select * from timetable " ;
		sql += " where no = ? " ;
		
		Student bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setInt(1, time_id);
			
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) {
				Timetable tbean = new Timetable();
				
				tbean.setTime_id(rs.getInt("time_id"));
				tbean.setSubject_code(rs.getInt("subject_code"));
				tbean.setClass_id(rs.getInt("class_id"));
				tbean.setTime(rs.getString("time"));
				tbean.setDay(rs.getString("day"));
				tbean.setRemark(rs.getString("remark"));
				tbean.setTid(rs.getString("tid"));
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

	public int InsertData(Timetable bean) {
		String sql = " insert into timetable (time_id, subject_code, class_id, time, day, remark, tid)";
		sql += " values(?, ?, ?, ?, ?, ?, ?) " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bean.getTime_id());
			pstmt.setInt(2, bean.getSubject_code());
			pstmt.setInt(3, bean.getClass_id());
			pstmt.setString(4, bean.getTime());
			pstmt.setString(5, bean.getDay());
			pstmt.setString(6, bean.getRemark());
			pstmt.setString(7, bean.getTid());
			
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

	public List<Timetable> SelectDataList(int i, int j) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select * from timetable" ;
		
		
		List<Timetable> lists = new ArrayList<Timetable>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Timetable bean = new Timetable();
				
				bean.setTime_id(rs.getInt("no"));
				bean.setSubject_code(rs.getInt("subject_code"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setTime(rs.getString("time"));
				bean.setDay(rs.getString("day"));
				bean.setRemark(rs.getString("remark"));
				bean.setTid(rs.getString("tid"));
				
				lists.add( bean ) ;
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
	
	public int UpdateData( Timetable bean ){
		String sql = " update Timetable set time_id = ?, subject_code = ?, class_id, " ; 
		sql += " time = ?, day = ?, remark = ?, tid =? " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
		
			pstmt.setInt(1, bean.getTime_id());
			pstmt.setInt(2, bean.getSubject_code());
			pstmt.setInt(3, bean.getClass_id());
			pstmt.setString(4, bean.getTime());
			pstmt.setString(5, bean.getDay());
			pstmt.setString(6, bean.getRemark());
			pstmt.setString(7, bean.getTid());
		
		
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
