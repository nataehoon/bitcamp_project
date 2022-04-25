package kids.board.activity_comment.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.board.activity.model.Activity;
import kids.common.model.SuperDao;
import kids.members.student.model.Student;

public class Activity_commentDao extends SuperDao {

	public int DeleteData(int activity_cmid) {
		String sql ;		
		PreparedStatement pstmt = null ;		
		Student bean = null ;
		int cnt = -99999 ;
		try {
			bean = this.SelectDataByPk(activity_cmid) ;
			
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			sql = " update activity set remark = ?  " ;
			sql += " where activity_cmid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			String imsi = bean.getName() +  "(" + activity_cmid + ")가 특별활동 아이디가 삭제 되었습니다." ;
			pstmt.setString(1, imsi);			
			pstmt.setInt(2, activity_cmid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			sql = " update employees set remark = ? " ;
			sql += " where activity_cmid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);			
			pstmt.setInt(2, activity_cmid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			sql = " update parents set remark = ? " ;
			sql += " where activity_cmid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);			
			pstmt.setInt(2, activity_cmid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			sql = " delete from activity_comment " ;
			sql += " where actino = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, activity_cmid);			
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
		return cnt ;
	}	

	private Student SelectDataByPk(int activity_cmid) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		
		String sql = " select * from activity_comment " ;
		sql += " where actino = ? " ;
		
		Student bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setInt(1, activity_cmid);
			
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) {
				Activity_comment acbean = new Activity_comment();
				
				acbean.setActivity_cmid(rs.getInt("activity_cmid"));
				acbean.setActino(rs.getInt("actino"));
				acbean.setContent(rs.getString("content"));
				acbean.setRegdate(String.valueOf(rs.getDate("regdate")));
				acbean.setRemark(rs.getString("remark"));
				acbean.setTid(rs.getString("tid"));
				acbean.setPid(rs.getString("pid"));
				acbean.setGroupno(rs.getInt("groupno"));
				acbean.setOrderno(rs.getInt("orderno"));
				acbean.setDepth(rs.getInt("depth"));
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

	public int InsertData(Activity_comment bean) {
		String sql = " insert into activity_comment(activity_cmid, actino, actino, regdate, remark, tid, pid, groupno, orderno, depth)"
		           + " values (activity_cmid_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
		 
		 PreparedStatement pstmt = null ;
			int cnt = -99999 ; 
			try {
				if( conn == null ){ super.conn = super.getConnection() ; }
				conn.setAutoCommit( false );
				pstmt = super.conn.prepareStatement(sql) ;
				
				pstmt.setInt(1, bean.getActino());
				pstmt.setString(2, bean.getContent());
				pstmt.setString(3, bean.getRegdate());
				pstmt.setString(4, bean.getRemark());
				pstmt.setString(5, bean.getTid());
				pstmt.setString(6, bean.getPid());
				pstmt.setInt(7, bean.getGroupno());
				pstmt.setInt(8, bean.getOrderno());
				pstmt.setInt(9, bean.getDepth());
				
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

	public List<Activity_comment> SelectDataList(int i, int j) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from Activity_comment " ;
		
		List<Activity_comment> lists = new ArrayList<Activity_comment>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Activity_comment bean = new Activity_comment() ;
				
				bean.setActivity_cmid(rs.getInt("activity_cmid"));
				bean.setActino(rs.getInt("actino"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setRemark(rs.getString("remark"));
				bean.setTid(rs.getString("tid"));
				bean.setPid(rs.getString("pid"));
				bean.setGroupno(rs.getInt("groupno"));
				bean.setOrderno(rs.getInt("orderno"));
				bean.setDepth(rs.getInt("depth"));
				
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
		
		return lists ;
	}
	public int UpdateData (Activity_comment bean) {
		String sql = " Update Activity_comment set activity_cmid = ?, actino = ?, content = ?, regdate = ?," ; 
		sql += " remark = ?, tid = ?, pid = ?, groupno = ?, orderno = ?, depth = ? " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bean.getActivity_cmid());
			pstmt.setInt(2, bean.getActino());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getRegdate());
			pstmt.setString(5, bean.getRemark());
			pstmt.setString(6, bean.getTid());
			pstmt.setString(7, bean.getPid());
			pstmt.setInt(8, bean.getGroupno());
			pstmt.setInt(9, bean.getOrderno());
			pstmt.setInt(10, bean.getDepth());
			
			
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