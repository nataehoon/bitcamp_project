package kids.board.notification_board.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.members.employees.model.Employees;

public class Notification_boardDao extends SuperDao {
	
	public int InsertData(Notification_board bean){
		PreparedStatement pstmt = null;
		String sql = " insert into noti_no_board values (dailyno_seq.nextval, ?, ?, ? ,? ";
			sql	+= " , sysdate, '안읽음', ?,null )" ;
			System.out.println(sql);
			int cnt = -99999;
			System.out.println(bean);
			try {
				if( conn == null ) { super.conn = super.getConnection();}
				conn.setAutoCommit(false);
				pstmt = super.conn.prepareStatement(sql);
				
				pstmt.setInt(1, bean.getClass_id());
				pstmt.setString(2, bean.getPid());
				pstmt.setString(3, bean.getContents());
				pstmt.setString(4, bean.getImage());
				pstmt.setInt(5, bean.getSend());
				
				cnt = pstmt.executeUpdate() ; 
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
	
	public List<Notification_board> getListByRecent(String pid, int class_id, int number){
		List<Notification_board> list = null;
		PreparedStatement pstmt = null;
		Notification_board bean = null;
		ResultSet rs = null;
		String sql = " select * from noti_no_board where ((pid = ? and class_id = ?) or (pid = ? and classid = ?)) ";
			sql	+= " and dailyno > (select MAX(dailyno) - ? from noti_no_board ) order by regdate ";
			
			try {
				if(conn == null) {super.conn = super.getConnection() ; }
				pstmt = conn.prepareStatement(sql) ;
				
				pstmt.setString(1, pid);
				pstmt.setInt(2, class_id);
				pstmt.setInt(3, class_id);
				pstmt.setString(4, pid);
				pstmt.setInt(5, number);
				
				rs = pstmt.executeQuery() ; 
				list = new ArrayList<Notification_board>();
				while(rs.next()) {
					bean = new Notification_board();
					
					bean.setChecks(rs.getString("checks"));
					bean.setClass_id(rs.getInt("class_id"));
					bean.setContents(rs.getString("contents"));
					bean.setDailyno(rs.getInt("dailyno"));
					bean.setImage(rs.getString("image"));
					bean.setPid(rs.getString("pid"));
					bean.setRegdate(rs.getString("regdate"));
					bean.setRemark(rs.getString("remark"));
					bean.setSend(rs.getInt("send"));
					
					list.add(bean);
				}
			} catch (Exception e) {			
				e.printStackTrace();
				bean = null ; 
			}finally {
				try {
					if(rs != null) {rs.close();}
					if(pstmt != null) {pstmt.close();} 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return list ;
	}
	
	
	public List<Notification_board> getListById(String pid, int class_id, int dailyno){
		List<Notification_board> list = null;
		PreparedStatement pstmt = null;
		Notification_board bean = null;
		ResultSet rs = null;
		String sql = "select * from noti_no_board where ((pid = ? and class_id = ?) or (pid = ? and classid = ?))";
			sql	+= " and dailyno > ? order by regdate";
			
			try {
				if(conn == null) {super.conn = super.getConnection() ; }
				pstmt = conn.prepareStatement(sql) ;
				
				pstmt.setString(1, pid);
				pstmt.setInt(2, class_id);
				pstmt.setInt(3, class_id);
				pstmt.setString(4, pid);
				pstmt.setInt(5, dailyno);
				
				rs = pstmt.executeQuery() ; 
				list = new ArrayList<Notification_board>();
				while(rs.next()) {
					bean = new Notification_board();
					
					bean.setChecks(rs.getString("checks"));
					bean.setClass_id(rs.getInt("class_id"));
					bean.setContents(rs.getString("contents"));
					bean.setDailyno(rs.getInt("dailyno"));
					bean.setImage(rs.getString("image"));
					bean.setPid(rs.getString("pid"));
					bean.setRegdate(rs.getString("regdate"));
					bean.setRemark(rs.getString("remark"));
					bean.setSend(rs.getInt("send"));
					// 시간 넣을지 생각해보
					list.add(bean);
				}
			} catch (Exception e) {			
				e.printStackTrace();
				bean = null ; 
			}finally {
				try {
					if(rs != null) {rs.close();}
					if(pstmt != null) {pstmt.close();} 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return list ;
	}
	public Employees SelectData(String id, String password) {
		Employees bean = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from employees where tid = ? and password = ? " ;
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery() ; 
			
			if(rs.next()) {
				bean = new Employees() ;
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setHp(rs.getString("hp"));
				bean.setImage(rs.getString("image"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setTid(rs.getString("tid"));
				bean.setSubmit(rs.getString("submit"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setSalary(rs.getInt("salary"));
				
			}
		} catch (Exception e) {			
			e.printStackTrace();
			bean = null ; 
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean ;
	}

	
	public Employees SelectDataByPk(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from employees ";
		sql += " where tid = ? ";
		
		Employees bean = null;
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Employees();
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setHp(rs.getString("hp"));
				bean.setImage(rs.getString("image"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setTid(rs.getString("tid"));
				bean.setSubmit(rs.getString("submit"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setSalary(rs.getInt("salary"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) {pstmt.close();}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return bean;
	}	
	
}
