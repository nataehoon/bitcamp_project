package kids.members.parents.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;

public class ParentsDao extends SuperDao {

	public int insertData(Parents bean) {
		int cnt = -99999;
		PreparedStatement pstmt = null ;
		String sql = "";
		
		if(bean.getChildid2() > 0) { 
			sql = "insert into parents "
					+ " (pid, name, hp, address1, address2, gender, password, birth, email, image, zipcode, sid, relationship, submit, responsibilities, childid2, childid)"
					+ " values"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		}else if(bean.getChildid() > 0) {
			sql = "insert into parents "
					+ " (pid, name, hp, address1, address2, gender, password, birth, email, image, zipcode, sid, relationship, submit, responsibilities, childid )"
					+ " values"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		}else {
			sql = "insert into parents "
					+ " (pid, name, hp, address1, address2, gender, password, birth, email, image, zipcode, sid, relationship, submit, responsibilities)"
					+ " values"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		}

		try {
			System.out.println("sql문 : "+sql);
			
			if(conn == null) {super.conn = super.getConnection() ; }
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getPid());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getHp());
			pstmt.setString(4, bean.getAddress1());
			pstmt.setString(5, bean.getAddress2());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getPassword());
			pstmt.setString(8, bean.getBirth());
			pstmt.setString(9, bean.getEmail());
			pstmt.setString(10, bean.getImage());
			pstmt.setString(11, bean.getZipcode());
			pstmt.setInt(12, bean.getSid());
			pstmt.setString(13, bean.getRelationship());
			pstmt.setString(14, bean.getSubmit());
			pstmt.setString(15, bean.getResponsibilities());
			
			if(bean.getChildid2() > 0) {
				pstmt.setInt(16, bean.getChildid());
				pstmt.setInt(17, bean.getChildid2());
			}else if(bean.getChildid() > 0) {
				pstmt.setInt(16, bean.getChildid());
			}
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit();
		} catch (Exception e) {	
			SQLException err = (SQLException)e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
		}finally {
			try {
				conn.rollback();
				if(pstmt != null) {pstmt.close();} 
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public Parents selectDataByPk(String pid) {
		Parents bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parents where pid = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Parents();
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setImage(rs.getString("image"));
				bean.setChildid(rs.getInt("childid"));
				bean.setChildid2(rs.getInt("childid2"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setResponsibilities(rs.getString("responsibilities"));
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

	public Parents selectData(String pid, String password) {
		Parents bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parents where pid = ? and password = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Parents();
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setImage(rs.getString("image"));
				bean.setChildid(rs.getInt("childid"));
				bean.setChildid2(rs.getInt("childid2"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setResponsibilities(rs.getString("responsibilities"));
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

	public Parents searchId(String name, String email) {
		Parents bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parents where name = ? and email = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Parents();
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setImage(rs.getString("image"));
				bean.setChildid(rs.getInt("childid"));
				bean.setChildid2(rs.getInt("childid2"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setResponsibilities(rs.getString("responsibilities"));
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

	public Parents searchPassword(String pid, String email) {
		Parents bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parents where pid = ? and email = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new Parents();
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setImage(rs.getString("image"));
				bean.setChildid(rs.getInt("childid"));
				bean.setChildid2(rs.getInt("childid2"));
				bean.setRemark(rs.getString("remark"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setResponsibilities(rs.getString("responsibilities"));
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

	public List<ParentsMiniView> selectDataList(String class_menu, String submit_menu) {
		List<ParentsMiniView> plists = new ArrayList<ParentsMiniView>();
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select * from parentsminiview ";
		
		if(class_menu.equalsIgnoreCase("all")) {
			// class_menu 값이 'all' 일 때
			
			if(submit_menu.equalsIgnoreCase("all")) {
				System.out.println("check1");
				// sql 문 뒤에 아무것도 안붙는다.
			}else {
				// submit 조건만 추가
				System.out.println("check2");
				sql += " where submit = ?";
			}
			
		}else {
			// class_menu 값이 'all' 이 아닐 때
			
			if(submit_menu.equalsIgnoreCase("all")) {
				//submit 조건이 안붙는다
				System.out.println("check3");
				sql += " where classname = ?";
				
			}else {
				// classname 조건과 submit 조건이 둘 다 붙는다.
				System.out.println("check4");
				sql += " where classname = ? and submit = ?";
			}
		}
			

		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			System.out.println("sql : "+sql);
			if(class_menu.equalsIgnoreCase("all")) {
				// class_menu 값이 'all' 일 때
				
				if(submit_menu.equalsIgnoreCase("all")) {
					// sql 문 뒤에 아무것도 안붙는다.
				}else {
					// submit 조건만 추가
					pstmt.setString(1, submit_menu);
				}
			}else {
				// class_menu 값이 'all' 이 아닐 때
				
				if(submit_menu.equalsIgnoreCase("all")) {
					//submit 조건이 안붙는다
					pstmt.setString(1, class_menu);
					
				}else {
					// classname 조건과 submit 조건이 둘 다 붙는다.
					pstmt.setString(1, class_menu);
					pstmt.setString(2, submit_menu);
				}
			}
			rs = pstmt.executeQuery() ;
			
			while ( rs.next()) {
				ParentsMiniView bean = new ParentsMiniView();
				bean.setClassname(rs.getString("classname"));
				bean.setStname(rs.getString("stname"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setPid(rs.getString("pid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setSubmit(rs.getString("submit"));
				
				plists.add(bean);
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
		return plists ;	
	}

	public boolean updateSubmit(String pid) {
		boolean check = false;
		PreparedStatement pstmt = null ;
		String sql = "update parents set submit = '승인' where pid = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			
			int cnt = pstmt.executeUpdate() ;
			if(cnt==1) {
				check = true;
			}
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
		return check;
	}

	public ParentsView selectDetailData(String pid) {
		ParentsView bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parentsview where pid = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new ParentsView();
				bean.setClassname(rs.getString("classname"));
				bean.setStname(rs.getString("stname"));
				bean.setClassname2(rs.getString("classname2"));
				bean.setStname2(rs.getString("stname2"));
				bean.setClassname3(rs.getString("classname3"));
				bean.setStname3(rs.getString("stname3"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setPid(rs.getString("pid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setGender(rs.getString("gender"));
				bean.setSubmit(rs.getString("submit"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setEmail(rs.getString("email"));
				bean.setImage(rs.getString("image"));
				bean.setRemark("remark");
				bean.setZipcode("zipcode");
				bean.setTid("employees");
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

	public int deleteData(String pid) {
		String sql ;		
		PreparedStatement pstmt = null ;		
		int cnt = -99999;
		
		try {
			Parents bean = this.selectDataByPk(pid) ;
			
			String imsi = bean.getName() +  "(" + pid + ")가 회원 탈퇴를 하였습니다." ;
			
			
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			
			// step01 : 투약의뢰서(medicine) 테이블 remark 컬럼 수정하기
			
			sql = " update medicine set remark = ?  " ;
			sql += " where pid = ? " ;
			
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, imsi);
			pstmt.setString(2, pid);
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			// step02 : 알림장(noti_no_board) 테이블 remark 컬럼 수정하기
			sql = " update noti_no_board set remark = ? " ;
			sql += " where pid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);			
			pstmt.setString(2, pid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			// step03 : 귀가동의서(re_home) 테이블 remark 컬럼 수정하기
			sql = " update re_home set remark = ? " ;
			sql += " where pid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);			
			pstmt.setString(2, pid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			// step04 : 특별활동 코멘트(activity_comment) 테이블 remark 컬럼 수정하기
			sql = " update activity_comment set remark = ? " ;
			sql += " where pid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);			
			pstmt.setString(2, pid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			// step05 : 부모 테이블 행 삭제하기
			sql = " delete from parents " ;
			sql += " where pid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);			
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

	public int updatePassword(String pid, String password) {
		int cnt = -99999;
		PreparedStatement pstmt = null ;
		String sql = "update parents set password = ? where pid = ?";
	
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, password);
			pstmt.setString(2, pid);
			
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

	public List<ParentsMiniView> login(String pid, String password) {
		List<ParentsMiniView> plists = new ArrayList<ParentsMiniView>();
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parentsminiview where pid = ? and password = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			pstmt.setString(2, password);
			System.out.println("checkcheck1");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("checkcheck2");
				ParentsMiniView bean = new ParentsMiniView();
				bean = new ParentsMiniView();
				bean.setClassname(rs.getString("classname"));
				bean.setStname(rs.getString("stname"));
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setPassword(rs.getString("password"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				System.out.println("checkcheck3");
				plists.add(bean);
				System.out.println("checkcheck4");
				bean.setTid("parents");
				bean.setClass_id(rs.getInt("class_id"));
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
		return plists;
	}

	public ParentsMiniView selectMiniData(String pid, int sid) {
		ParentsMiniView bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parentsminiview where pid = ? and sid = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			pstmt.setInt(2, sid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bean = new ParentsMiniView();
				bean.setClassname(rs.getString("classname"));
				bean.setStname(rs.getString("stname"));
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setPassword(rs.getString("password"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setTid("parents");
				bean.setClass_id(rs.getInt("class_id"));
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

	public ParentsMiniView login2(String pid, String password) {
		ParentsMiniView bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parentsminiview where pid = ? and password = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, pid);
			pstmt.setString(2, password);
			System.out.println("checkcheck1");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("checkcheck2");
				bean = new ParentsMiniView();
				bean.setClassname(rs.getString("classname"));
				bean.setStname(rs.getString("stname"));
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setPassword(rs.getString("password"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
				System.out.println("checkcheck3");
				bean.setTid("parents");
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

	public int updateData(Parents bean) {
		int cnt = -99999;
		PreparedStatement pstmt = null ;
		String sql = "";
		if(bean.getChildid2() > 0) { 
			sql = "update parents set name = ?, hp =?, address1 =?, address2 =?, gender = ?, password = ?, "
					+ " birth = ?, email =?, image = ?, zipcode = ?, sid = ?, relationship = ?, submit = ?, "
					+ " responsibilities = ?, childid = ? , childid2 = ? where pid = ?";
		}else if(bean.getChildid() > 0) {
			sql ="update parents set name = ?, hp =?, address1 =?, address2 =?, gender = ?, password = ?, "
					+ " birth = ?, email =?, image = ?, zipcode = ?, sid = ?, relationship = ?, submit = ?, "
					+ " responsibilities = ?, childid = ? where pid = ?";
		}else {
			sql = "update parents set name = ?, hp =?, address1 =?, address2 =?, gender = ?, password = ?, "
					+ " birth = ?, email =?, image = ?, zipcode = ?, sid = ?, relationship = ?, submit = ?, "
					+ " responsibilities = ? where pid = ?";
		}

		try {
			System.out.println("sql문 : "+sql);
			
			if(conn == null) {super.conn = super.getConnection() ; }
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getPid());
			
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getHp());
			pstmt.setString(3, bean.getAddress1());
			pstmt.setString(4, bean.getAddress2());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getPassword());
			pstmt.setString(7, bean.getBirth());
			pstmt.setString(8, bean.getEmail());
			pstmt.setString(9, bean.getImage());
			pstmt.setString(10, bean.getZipcode());
			pstmt.setInt(11, bean.getSid());
			pstmt.setString(12, bean.getRelationship());
			pstmt.setString(13, bean.getSubmit());
			pstmt.setString(14, bean.getResponsibilities());
			
			if(bean.getChildid2() > 0) {
				pstmt.setInt(15, bean.getChildid());
				pstmt.setInt(16, bean.getChildid2());
				pstmt.setString(17, bean.getPid());
			}else if(bean.getChildid() > 0) {
				pstmt.setInt(15, bean.getChildid());
				pstmt.setString(16, bean.getPid());
			}else {
				pstmt.setString(15, bean.getPid());
			}
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit();
		} catch (Exception e) {	
			SQLException err = (SQLException)e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
		}finally {
			try {
				conn.rollback();
				if(pstmt != null) {pstmt.close();} 
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public List<ParentsMiniView> selectPidList(int sid) {
		List<ParentsMiniView> plists = new ArrayList<ParentsMiniView>();
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from parentsminiview where sid = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setInt(1, sid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ParentsMiniView bean = new ParentsMiniView();
				bean.setClassname(rs.getString("classname"));
				bean.setStname(rs.getString("stname"));
				bean.setPid(rs.getString("pid"));
				bean.setSid(rs.getInt("sid"));
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setRelationship(rs.getString("relationship"));
				bean.setSubmit(rs.getString("submit"));
				bean.setPassword(rs.getString("password"));
				bean.setResponsibilities(rs.getString("responsibilities"));
				bean.setClass_id(rs.getInt("class_id"));
		} }catch (Exception e) {	
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
		return plists;
	}
		
}
