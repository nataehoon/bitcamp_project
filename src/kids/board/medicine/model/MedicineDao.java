package kids.board.medicine.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;


public class MedicineDao extends SuperDao {

	public int GetGroupnoCount(int groupno) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select count(*) as cnt from Stu_fees " ;
		sql += " where groupno = ? ";
		
		int cnt = 0; 
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			 
			
			pstmt.setInt(1, groupno);
			
			rs = pstmt.executeQuery() ; 
			
			if (rs.next()) {
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
	
/*	public int ReplyData( Stu_fee bean ){
		String sql = " update Stu_fees set orderno = orderno + 1 ";
		sql += " where groupno = ? and orderno > ? ";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, bean.getGroupno());
			pstmt.setInt(2, bean.getOrderno());
			
			cnt = pstmt.executeUpdate() ;
			
			sql = " insert into Stu_fees " ;
			sql += " (" ;
			sql += " no, subject, writer, password, content, groupno, orderno, depth " ;
			sql += " )" ;
			sql += " values" ;
			sql += " (" ;
			sql += " myStu_fee.nextval, ?, ?, ?, ?, ?, ?, ?" ;
			sql += " )" ;
		
			pstmt = null;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getContent());
			pstmt.setInt(5, bean.getGroupno());
			pstmt.setInt(6, bean.getOrderno() + 1);
			pstmt.setInt(7, bean.getDepth() + 1);
			
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
	*/
	public int InsertData( Medicine2 bean ){
		String sql = " insert into medicine(meno, pid, tid, regdate, category, amount, reps, hour, storagemethod, ";
		sql += " textarea, checks, remark, sid) ";
		sql += " values(meno_seq.nextval, ?, ";
		sql += " (select tid from ";
		sql += " employees a join student b ";
		sql += " on a.class_id = b.class_id ";
		sql += " where sid = ?), ";
		sql += " to_char(sysdate,'yyyy/mm/dd'),?,?,?,?,?,?,'안읽음',?,?) ";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getPid());
			pstmt.setInt(2, bean.getSid());
			pstmt.setString(3, bean.getCategory());
			pstmt.setString(4, bean.getAmount());
			pstmt.setInt(5, bean.getReps());
			pstmt.setString(6, bean.getHour());
			pstmt.setString(7, bean.getStoragemethod());
			pstmt.setString(8, bean.getTextarea());
			pstmt.setString(9, bean.getRemark());
			pstmt.setInt(10, bean.getSid());
			System.out.println(pstmt);
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
	/*
	public int UpdateData( Medicine2 bean ){
		String sql = " update Stu_fees set content=?, password=?, subject=?, writer=?, readhit=? " ;
		sql += " where no = ? " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;

			pstmt.setString(1, bean.getContent());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getWriter());
			pstmt.setInt(5, bean.getReadhit());
			pstmt.setInt(6, bean.getNo());
			
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
	*/
	public int CheckData( int meno ){
		String sql = " update medicine set checks = '읽음' " ;
		sql += " where meno = ? " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;

			pstmt.setInt(1, meno);
			
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
	
	public int DeleteData( int meno ){
		String sql = " delete from medicine " ;
		sql += " where meno = ? " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, meno);
			
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
	

	public List<Medicine2> SelectDataList() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select distinct b.class_id, c.class_name from " ;
		sql += " medicine a inner join student b ";
		sql	+= " on (a.sid = b.sid) inner join myclass c on (b.class_id = c.class_id) ";
		
		List<Medicine2> lists = new ArrayList<Medicine2>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Medicine2 bean = new Medicine2();
				bean.setClass_id(rs.getInt("class_id"));
				bean.setClass_name(rs.getString("class_name"));
							 				 
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
	
	public Medicine2 SelectDataByPk( int meno ){
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		String sql = " select * from medicine a inner join student b ";
		sql += " on (a.sid = b.sid) inner join myclass c on (b.class_id = c.class_id) ";
		sql += " where meno = ? ";
		
		Medicine2 bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setInt( 1, meno ); 
			
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				bean = new Medicine2();
				bean.setAmount(rs.getString("amount"));
				bean.setCategory(rs.getString("category"));
				bean.setChecks(rs.getString("checks"));
				bean.setClass_name(rs.getString("class_name"));
				bean.setHour(rs.getString("hour"));
				bean.setMeno(rs.getInt("meno"));
				bean.setName(rs.getString("name"));
				bean.setPid(rs.getString("pid"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setRemark(rs.getString("remark"));
				bean.setReps(rs.getInt("reps"));
				bean.setStoragemethod(rs.getString("storagemethod"));
				bean.setTextarea(rs.getString("textarea"));
				bean.setTid(rs.getString("tid"));
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
	
	public List<Medicine2> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * ";
		sql += " from (select a.meno, a.regdate, b.name, a.checks, c.class_name, a.pid, a.tid, a.sid ,c.class_id, ";
		sql += " rank() over(order by a.checks, a.meno desc, a.regdate desc, b.name) as ranking ";
		sql += " from medicine a join student b ";
		sql += " on a.sid = b.sid join myclass c ";
		sql += " on b.class_id = c.class_id ";
		
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
				sql += " ) ";
				sql += " where ranking between ? and ? ";
					
		List<Medicine2> lists = new ArrayList<Medicine2>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow); 
			
			System.out.println(sql);	
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				Medicine2 bean = new Medicine2() ;
				//bean.setAmount(rs.getString("amount"));
				//bean.setCategory(rs.getString("category"));
				bean.setChecks(rs.getString("checks"));
				bean.setClass_name(rs.getString("class_name"));
				//bean.setHour(rs.getString("hour"));
				bean.setMeno(rs.getInt("meno"));
				bean.setName(rs.getString("name"));
				bean.setPid(rs.getString("pid"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				//bean.setRemark(rs.getString("remark"));
				//bean.setReps(rs.getInt("reps"));
				//bean.setStoragemethod(rs.getString("storagemethod"));
				//bean.setTextarea(rs.getString("textarea"));
				bean.setTid(rs.getString("tid"));
				bean.setSid(Integer.parseInt(rs.getString("sid")));
				bean.setClass_id(rs.getInt("class_id"));
				
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
	/*
	public List<Stu_fee> SelectDataList(int beginRow, int endRow) {
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " " ;
		sql += " " ;
		sql += " " ; 

		List<Stu_fee> lists = new ArrayList<Stu_fee>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow); 
			
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				Stu_fee bean = new Stu_fee() ; 
			 		
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
	public int UpdateReadhit(int no) {
	      PreparedStatement pstmt = null ;
	      
	      String sql = " update Stu_fees set readhit = readhit + 1 " ;
	      sql += " where no = ? " ;
	      
	      
	      int cnt = -99999 ; 
	      
	      try {
	         if( this.conn == null ){ this.conn = this.getConnection() ; }
	         conn.setAutoCommit( false ); 
	         pstmt = this.conn.prepareStatement( sql ) ;
	         
	         pstmt.setInt(1, no);
	         
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
	   }*/
	public int SelectTotalCount(String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		String sql = " select count(*) as cnt ";
		sql += " from (select a.meno, a.regdate, b.name, a.checks, c.class_name, ";
		sql += " rank() over(order by a.checks, a.meno desc, a.regdate desc, b.name) as ranking ";
		sql += " from medicine a join student b ";
		sql += " on a.sid = b.sid join myclass c ";
		sql += " on b.class_id = c.class_id ) ";
		
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
				
		System.out.println(sql);
		int cnt = 0; 
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			 
			rs = pstmt.executeQuery() ; 
			
			if (rs.next()) {
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
/*
	public int UpdateReply(int groupno, int orderno) {
		PreparedStatement pstmt = null ;
		String sql = " " ;
		sql += " " ;
		sql += " " ;
		
		int cnt = -99999 ; 
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			conn.setAutoCommit( false ); 
			pstmt = this.conn.prepareStatement( sql ) ;
			
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
	

	public int UpdateRemark(String id) {
		PreparedStatement pstmt = null ;
		String sql = " " ;
		sql += " " ;
		sql += " " ;
		int cnt = -99999 ;  
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			conn.setAutoCommit( false ); 
			pstmt = this.conn.prepareStatement( sql ) ;
			
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
		return cnt ; */

	
	}



