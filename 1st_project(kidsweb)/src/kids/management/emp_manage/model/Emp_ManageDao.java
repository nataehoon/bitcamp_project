package kids.management.emp_manage.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.members.employees.model.Employees;

public class Emp_ManageDao extends SuperDao {
	public List<Emp_Manage> SelectList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, tid, class_id, name, join_date, salary, image, birth, hp, address1, " ;
		sql += " address2, gender, responsibilities, password, subject_code, email, zipcode, remark from ( ";
		sql += " select tid, class_id, name, join_date, salary, image, birth, hp, address1, ";
		sql += " address2, gender, responsibilities, password, subject_code, email, zipcode, remark, rank() over(order by name asc) ";
		sql += " as ranking from employees where responsibilities = ? ";
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " and " + mode + "like '%" + keyword + "%' " ;
		}
		sql += " ) where ranking between ? and ? ";
		
		List<Emp_Manage> lists = new ArrayList<Emp_Manage>();
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			pstmt.setString(1, "직원");
			pstmt.setInt(2, beginRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) { 
				Emp_Manage bean = new Emp_Manage();
				
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
	public int UpdateData(Employees bean) {
		String sql = " update employees set address1 = ?, address2 = ?, birth = ?, email = ?, " ;
		sql += " gender = ?, hp = ?, image = ?, name = ?, password = ?, zipcode = ?, class_id = ?, ";
		sql += " subject_code = ?, salary = ? where tid = ? ";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = this.conn.prepareStatement(sql) ;	

			pstmt.setString(1, bean.getAddress1());
			pstmt.setString(2, bean.getAddress2());
			pstmt.setString(3, bean.getBirth());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getHp());
			pstmt.setString(7, bean.getImage());
			pstmt.setString(8, bean.getName());
			pstmt.setString(9, bean.getPassword());
			pstmt.setString(10, bean.getZipcode());
			pstmt.setInt(11, bean.getClass_id());
			pstmt.setInt(12, bean.getSubject_code());
			pstmt.setInt(13, bean.getSalary());
			pstmt.setString(14, bean.getTid());
			
			
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

	public int selectEmpCount(String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select count(*) as cnt from employees " ;
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + "like '%" + keyword + "%' " ;
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

	public List<Emp_Manage> SelectEmpData(String datefr,String dateto,String tid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT DECODE( TO_CHAR( A.CALDATE, 'DAY' ),'월요일',1,'화요일',2,'수요일',3,'목요일',4,5) as regday, " 
				+ " A.CALDATE, B.EMP_MNO, TID, NVL2(ATTENDANCE,'('||ATTENDANCE||')','(결근)') AS ATTENDANCE, "
				+ " NVL(TO_CHAR(REGDATE, 'MM/DD HH24:MI'), TO_CHAR( A.CALDATE, 'MM/DD' )) as REGDATE  , REMARK "
				+ " FROM ( "
				+ " SELECT FIRST_DAY + LEVEL - 1 AS CALDATE "
				+ " FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') FIRST_DAY FROM DUAL) "
				+ " CONNECT BY FIRST_DAY + LEVEL - 1 <= TO_DATE(?, 'YYYY-MM-DD') "
				+ " ) A "
				+ " LEFT JOIN emp_manage B "
				+ " ON TO_CHAR(A.CALDATE, 'YYYY-MM-DD') = TO_CHAR(B.REGDATE, 'YYYY-MM-DD') "
				+ " AND B.tid = ? "
				+ " where TO_CHAR( A.CALDATE, 'DAY' ) not in ('토요일','일요일') "
				+ " order by A.CALDATE ";
		
		List<Emp_Manage> lists = new ArrayList<Emp_Manage>();
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);

			pstmt.setString(1, datefr);
			pstmt.setString(2, dateto);
			pstmt.setString(3, tid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Emp_Manage bean = new Emp_Manage();
				
				//String str = rs.getString("regdate");
				
				bean.setAttendance(rs.getString("attendance"));
				bean.setEmp_mno(rs.getInt("emp_mno"));
				bean.setRegdate( rs.getString("regdate") );
				bean.setTid(rs.getString("tid"));
				bean.setRemark(rs.getString("remark"));
				bean.setRegday(rs.getInt("regday"));
				
				lists.add(bean);
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
		
		return lists;
	}
	public int AttData(String tid) {
		PreparedStatement pstmt = null;
		int cnt = -99999;
		
		String sql = " insert into emp_manage(emp_mno, tid, attendance, regdate, remark) ";
		sql += " values(emp_mno_seq.nextval, ?, '출석', sysdate, null) ";
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tid);
			
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
		return cnt ; 
	}
	public int AttAfterData(String tid) {
		PreparedStatement pstmt = null;
		int cnt = -99999;
		
		String sql = " insert into emp_manage(emp_mno, tid, attendance, regdate, remark) ";
		sql += " values(emp_mno_seq.nextval, ?, '퇴근', sysdate, null) ";
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tid);
			
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
		return cnt ; 
	}
	public Emp_Manage EmpmAttData(String tid, String attendance) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from emp_manage where tid = ? ";
			sql	+= " and to_char(regdate) = to_char(sysdate,'yy/mm/dd') ";
			sql	+= " and attendance = ? ";
		
		Emp_Manage bean = null;
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tid);
			pstmt.setString(2, attendance);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Emp_Manage();
				
				String str = rs.getString("regdate");
				
				bean.setAttendance(rs.getString("attendance"));
				bean.setEmp_mno(rs.getInt("emp_mno"));
				bean.setRegdate(str.substring(5, 16));
				bean.setTid(rs.getString("tid"));
				bean.setRemark(rs.getString("remark"));
				
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
	public Emp_Manage EmpmDetailData(String tid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from emp_manage where tid = ? ";
		
		Emp_Manage bean = null;
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Emp_Manage();
				
				String str = rs.getString("regdate");
				
				bean.setAttendance(rs.getString("attendance"));
				bean.setEmp_mno(rs.getInt("emp_mno"));
				bean.setRegdate(str.substring(5, 16));
				bean.setTid(rs.getString("tid"));
				bean.setRemark(rs.getString("remark"));
				
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
