package kids.members.employees.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;

public class EmployeesDao extends SuperDao {

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
				System.out.println("sss");
				bean = new Employees() ;
				
				
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
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
				bean.setSubject_code(rs.getInt("subject_code"));
				bean.setPid("employees");
				
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

	public int InsertData(Employees bean) {
		PreparedStatement pstmt = null;
		
		String sql = " insert into employees(tid, class_id, name, join_date, salary, image, birth, hp, address1, address2, gender, responsibilities, password, submit, subject_code, remark, email, zipcode) ";
			sql += " values(?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		int cnt = -99999;
		System.out.println(bean);
		try {
			if( conn == null ) { super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getTid());
			pstmt.setInt(2, bean.getClass_id());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getSalary());
			pstmt.setString(5, bean.getImage());
			pstmt.setString(6, bean.getBirth());
			pstmt.setString(7, bean.getHp());
			pstmt.setString(8, bean.getAddress1());
			pstmt.setString(9, bean.getAddress2());
			pstmt.setString(10, bean.getGender());
			pstmt.setString(11, bean.getResponsibilities());
			pstmt.setString(12, bean.getPassword());
			pstmt.setString(13, bean.getSubmit());
			pstmt.setInt(14, bean.getSubject_code());
			pstmt.setString(15, bean.getRemark());
			pstmt.setString(16, bean.getEmail());
			pstmt.setString(17, bean.getZipcode());
			
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

	public Employees SelectDataByPk(String tid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from employees ";
		sql += " where tid = ? ";
		
		Employees bean = null;
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tid);
			
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

	public int selectEmpCount(String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select count(*) as cnt from employees " ;
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

	public List<Employees> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, tid, name, gender, birth, hp, email, submit, remark from ( " ;
		sql += "  select tid, name, gender, birth, hp, email, submit, remark, rank() over(order by name desc) ";
		sql += " as ranking from employees where submit = ? ";
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " and " + mode + "like '%" + keyword + "%' " ;
		}
		sql += " ) where ranking between ? and ? ";
		
		List<Employees> lists = new ArrayList<Employees>();
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			String nosub = "미승인";
			
			pstmt.setString(1, nosub);
			pstmt.setInt(2, beginRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) { 
				Employees bean = new Employees();

				bean.setBirth(rs.getString("birth"));
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setHp(rs.getString("hp"));
				bean.setName(rs.getString("name"));
				bean.setTid(rs.getString("tid"));
				bean.setSubmit(rs.getString("submit"));
				
				lists.add(bean);
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

	public int SubmitUpdate(String tid) {
		String sql = " update employees set submit = ? where tid = ?" ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = this.conn.prepareStatement(sql) ;	
			
			String upsub = "승인";
			pstmt.setString(1, upsub);
			pstmt.setString(2, tid);
			
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

	public List<Employees> SelectList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select ranking, tid, class_id, name, join_date, salary, image, birth, hp, address1, " ;
		sql += " address2, gender, responsibilities, password, subject_code, email, zipcode, remark from ( ";
		sql += " select tid, class_id, name, join_date, salary, image, birth, hp, address1, ";
		sql += " address2, gender, responsibilities, password, subject_code, email, zipcode, remark, rank() over(order by name asc) ";
		sql += " as ranking from employees where responsibilities not in ? ";
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " and " + mode + " like '%" + keyword + "%' " ;
		}
		sql += " ) where ranking between ? and ? ";
		
		List<Employees> lists = new ArrayList<Employees>();
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			pstmt.setString(1, "원장");
			pstmt.setInt(2, beginRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) { 
				Employees bean = new Employees();
				
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
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setSalary(rs.getInt("salary"));
				bean.setJoin_date(rs.getString("join_date"));
				bean.setSubject_code(rs.getInt("subject_code"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				
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

	public Employees DetailData(String tid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from (select e.tid, e.class_id, e.name, e.join_date, e.salary, e.image, e.birth, e.hp, e.address1, "
				+ " e.address2, e.gender, e.responsibilities, e.password, e.subject_code, e.email, e.zipcode, e.remark, e.subject, c.class_name "
				+ " from ( select e.tid, e.class_id, e.name, e.join_date, e.salary, e.image, e.birth, e.hp, e.address1, "
				+ " e.address2, e.gender, e.responsibilities, e.password, e.subject_code, e.email, e.zipcode, e.remark, s.subject "
				+ " from employees e inner join subject s "
				+ " on e.subject_code = s.subject_code ) e inner join myclass c "
				+ " on e.class_id = c.class_id) where tid = ? ";
		
		Employees bean = null;
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Employees();
				
				String str = rs.getString("birth");
				
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(str.substring(0, 10));
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setHp(rs.getString("hp"));
				bean.setImage(rs.getString("image"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setTid(rs.getString("tid"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setSalary(rs.getInt("salary"));
				bean.setJoin_date(rs.getString("join_date"));
				bean.setSubject_code(rs.getInt("subject_code"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setClass_name(rs.getString("class_name"));
				bean.setSubject(rs.getString("subject"));
				
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

	public int UpdateData(Employees bean) {
		String sql = " update employees set address1 = ?, address2 = ?, birth = ?, email = ?, " ;
		sql += " gender = ?, hp = ?, image = ?, name = ?, password = ?, zipcode = ?, class_id = ?, ";
		sql += " subject_code = ? where tid = ? ";
		
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
			pstmt.setString(13, bean.getTid());
			
			
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

	public int DeleteData(String tid) {
		String sql = "";
		PreparedStatement pstmt = null;
		int cnt = -99999;
		
		try {
			if(conn == null ) {super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			
			//remark
			sql += " update employees set remark = ? ";
			sql += " where tid = ? ";
			pstmt = super.conn.prepareStatement(sql);
			
			Employees bean = this.SelectDataByPk(tid);
			String imsi = bean.getName() + " ( " + bean.getTid() + " ) " + "선생님이 퇴사히였습니다.";
			
			pstmt.setString(1, imsi);
			pstmt.setString(2, tid);
			cnt = pstmt.executeUpdate();
			conn.commit();
			if(pstmt != null) {pstmt.close();}
			
			//삭제
			if(conn == null ) {super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			
			sql += " delete from employees where tid = ? ";
			pstmt = super.conn.prepareStatement(sql);
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
		return cnt  ; 
	}

	public List<Employees> getEmployeesList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from employees where responsibilities = ? or responsibilities = ? ";
		
		List<Employees> lists = new ArrayList<Employees>();
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, "직원");
			pstmt.setString(2, "특활");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employees bean = new Employees();
				
				String str = rs.getString("birth");
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(str.substring(0, 10));
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setHp(rs.getString("hp"));
				bean.setImage(rs.getString("image"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setTid(rs.getString("tid"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setSalary(rs.getInt("salary"));
				bean.setJoin_date(rs.getString("join_date"));
				bean.setSubject_code(rs.getInt("subject_code"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				
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

	public Employees Employees(String name, String email) {
		Employees bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from employees where name = ? and email = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Employees();
				
				bean.setTid(rs.getString("tid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setSubmit(rs.getString("submit"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setImage(rs.getString("image"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setJoin_date(rs.getString("zipcode"));
				bean.setSalary(rs.getInt("salary"));
				bean.setSubject_code(rs.getInt("subject_code"));
				
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();} 
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	public int updatePassword(String tid, String password) {
		int cnt = -99999;
		PreparedStatement pstmt = null ;
		String sql = "update employees set password = ? where tid = ?";
	
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, password);
			pstmt.setString(2, tid);
			
			cnt = pstmt.executeUpdate() ; 
		} catch (Exception e) {	
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();} 
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public Employees searchPassword(String tid, String email) {
		Employees bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from employees where tid = ? and email = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, tid);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Employees();
				
				String str = rs.getString("birth");
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(str.substring(0, 10));
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setHp(rs.getString("hp"));
				bean.setImage(rs.getString("image"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setTid(rs.getString("tid"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setSalary(rs.getInt("salary"));
				bean.setJoin_date(rs.getString("join_date"));
				bean.setSubject_code(rs.getInt("subject_code"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();} 
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	public int EmpmUpdateData(Employees bean) {
		PreparedStatement pstmt = null;
		
		String sql = " update employees set class_id = ?, salary = ?, image = ?, hp = ?, address1 = ?, address2 = ?, "
				+ " responsibilities = ?, subject_code = ?, remark = ?, zipcode = ? where tid = ? " ;
		
		int cnt = -99999;
		System.out.println(bean);
		try {
			if( conn == null ) { super.conn = super.getConnection();}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getClass_id());
			pstmt.setInt(2, bean.getSalary());
			pstmt.setString(3, bean.getImage());
			pstmt.setString(4, bean.getHp());
			pstmt.setString(5, bean.getAddress1());
			pstmt.setString(6, bean.getAddress2());
			pstmt.setString(7, bean.getResponsibilities());
			pstmt.setInt(8, bean.getSubject_code());
			pstmt.setString(9, bean.getRemark());
			pstmt.setString(10, bean.getZipcode());
			pstmt.setString(11, bean.getTid());
			
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

	public List<Employees> getEmployeesListAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from employees";
		
		List<Employees> lists = new ArrayList<Employees>();
		
		try {
			if(this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employees bean = new Employees();
				
				String str = rs.getString("birth");
				
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(str.substring(0, 10));
				bean.setEmail(rs.getString("email"));
				bean.setGender(rs.getString("gender"));
				bean.setHp(rs.getString("hp"));
				bean.setImage(rs.getString("image"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setTid(rs.getString("tid"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				bean.setSalary(rs.getInt("salary"));
				bean.setJoin_date(rs.getString("join_date"));
				bean.setSubject_code(rs.getInt("subject_code"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				
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

	
}
