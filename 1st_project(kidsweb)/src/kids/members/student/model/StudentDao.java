package kids.members.student.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.board.timetable.model.Timetable;
import kids.common.model.SuperDao2;
import kids.management.myclass.model.Myclass;

public class StudentDao extends SuperDao2{
	
	public int UpdateData( Student bean ){
		String sql = " update Myclass set sid = ?, class_id = ?, name = ?, hp = ?, " ;
		sql += " birth = ?, address1 = ?, address2 = ?, gender = ?, regdate = ?,  " ;
		sql += " textarea = ?, image = ?, remark = ? zipcode = ? where sid = ? " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bean.getSid());
			pstmt.setInt(2, bean.getClass_id());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getHp());
			pstmt.setString(5, bean.getBirth());
			pstmt.setString(6, bean.getAddress1());
			pstmt.setString(7, bean.getAddress2());
			pstmt.setString(8, bean.getGender());
			pstmt.setString(9, bean.getRegdate());
			pstmt.setString(10, bean.getTextarea());
			pstmt.setString(11, bean.getImage());
			pstmt.setString(12, bean.getRemark());
			pstmt.setString(13, bean.getZipcode());
			
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
	

	public int insertData(Student bean) {
		String sql = "insert into student (sid, name, hp, birth, address1, address2, gender, textarea, image,zipcode,regdate)"
				+ " values( sid_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?,?,to_char(sysdate,'yyyy/mm/dd')) " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ; 
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getHp());
			pstmt.setString(3, bean.getBirth());
			pstmt.setString(4, bean.getAddress1());
			pstmt.setString(5, bean.getAddress2());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getTextarea());
			pstmt.setString(8, bean.getImage());
			pstmt.setString(9, bean.getZipcode());
		
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

	@SuppressWarnings("resource")
	public int DeleteData( int sid) {
		String sql ;		
		PreparedStatement pstmt = null ;		
		Student bean = null ;
		int cnt = -99999 ;
		try {
			bean = this.SelectDataByPk(sid) ;
			
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );	
		
			sql = " update parents set remark = ?  " ;
			sql += " where sid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			String imsi = bean.getName() +  "(" + sid + ")가 회원 탈퇴를 하였습니다." ;
			pstmt.setString(1, imsi);			
			pstmt.setInt(2, sid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
		
			sql = " update stu_fee set remark = ? " ;
			sql += " where sid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, imsi);			
			pstmt.setInt(2, sid);
			
			cnt = pstmt.executeUpdate() ;
			if(pstmt != null) {pstmt.close();}
			
			sql = " delete from students " ;
			sql += " where sid = ? " ;
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, sid);			
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
	

	public int SelectTotalCount(String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select count(*) as cnt from student " ;
		if(mode.equalsIgnoreCase("all") ==false) { 
			System.out.println("not all search mode");
			sql += " where " + mode + " like '%" + keyword + "%' " ;	
		}
		
		int cnt = 0 ; 
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			 
			rs = pstmt.executeQuery() ; 
			
			if (rs.next()) {
				cnt = rs.getInt("cnt") ;
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


	public List<Student> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " " ;
		sql += " " ;
		sql += " " ; 

		List<Student> lists = new ArrayList<Student>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow); 
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) {
				Student bean = new Student() ; 
			
			bean.setAddress1(rs.getString("address1"));
			bean.setAddress2(rs.getString("address2"));
			bean.setBirth(rs.getString("birth"));
			bean.setGender(rs.getString("gender"));
			bean.setHp(rs.getString("hp"));
			bean.setImage(rs.getString("image"));
			bean.setName(rs.getString("name"));
			bean.setClass_id(rs.getInt("class_id"));
			bean.setZipcode(rs.getString("zipcode"));
				
				
			 		
				lists.add( bean ) ; 
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

	public Student SelectDataByPk(int no) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		
		String sql = " select * from students " ;
		sql += " where class_id = ? " ;
		
		Student bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				bean = new Student() ;
				
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setBirth(rs.getString("birth"));
				bean.setGender(rs.getString("gender"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setTextarea(rs.getString("textarea"));
				bean.setImage(rs.getString("image"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setSid(rs.getInt("sid"));
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
		return bean  ;
	}
	public List<Student> SelectDataListByPk(int no) { // 시영만
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		
		String sql = " select * from student " ;
		if(no == 0) {
			
		}else {
			sql += " where class_id = ? " ;
		}
		
		List<Student> lists = new ArrayList<Student>();
		Student bean = null;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			if(no == 0) {
				
			}else {
				pstmt.setInt(1, no);
			}	
			
			
			rs = pstmt.executeQuery() ; 
			
			while ( rs.next() ) { 
				bean = new Student() ;
				
				bean.setName(rs.getString("name"));
				bean.setHp(rs.getString("hp"));
				bean.setBirth(rs.getString("birth"));
				bean.setGender(rs.getString("gender"));
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setTextarea(rs.getString("textarea"));
				bean.setImage(rs.getString("image"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setSid(rs.getInt("sid"));
				
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
	public Student selectByData(String name, String hp) {
	      Student bean = null;
	      PreparedStatement pstmt = null ;
	      ResultSet rs = null;
	      String sql = "select * from student where name=? and hp=?";
	      
	      try {
	         if(conn == null) {super.conn = super.getConnection() ; }
	         pstmt = conn.prepareStatement(sql) ;
	         pstmt.setString(1, name);
	         pstmt.setString(2, hp);
	         System.out.println("stsearch - pstmt.setString 까지 완료");
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	 System.out.println("stsearch - rs.next 들어옴");
	        	 bean = new Student();
	        	 bean.setSid(rs.getInt("sid"));
	        	 bean.setName(rs.getString("name"));
	        	 bean.setHp(rs.getString("hp"));
	        	 bean.setBirth(rs.getString("birth"));
	        	 bean.setGender(rs.getString("gender"));
	        	 bean.setAddress1(rs.getString("address1"));
	        	 bean.setAddress2(rs.getString("address2"));
	        	 bean.setRegdate(String.valueOf(rs.getDate("regdate")));
	        	 bean.setTextarea(rs.getString("textarea"));
	        	 bean.setImage(rs.getString("image"));
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


	public List<Student> selectDataList(int class_id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select * from student where class_id = ?" ;

		List<Student> lists = new ArrayList<Student>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setInt(1, class_id);
			
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
				lists.add( bean ) ; 
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
	public List<Student> selectDataList(int BeginRow, 
			int EndRow, 
			String Mode, 
			String keyword ) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select * from student where class_id = ?" ;

		List<Student> lists = new ArrayList<Student>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			
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
				lists.add( bean ) ; 
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
