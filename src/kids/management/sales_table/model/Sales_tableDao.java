package kids.management.sales_table.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;


public class Sales_tableDao extends SuperDao {

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
	
	public int InsertData( Stu_fee bean ){
		String sql = " insert into Stu_fees(no, subject, writer, password, content, groupno ) " ;
		sql += " values(myStu_fee.nextval, ?, ?, ?, ?, myStu_fee.currval) " ;

		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getContent());
		
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
	public int UpdateData( Stu_fee bean ){
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
	public int DeleteData( int no ){
		String sql = " delete from Stu_fees " ;
		sql += " where no = ?" ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, no);
			
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
	
	public Stu_feeDao() {
	
	}*/
	public List<Sales_table2> SelectDataList() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " " ;
		sql += " " ;
		sql += " " ;
		
		List<Sales_table2> lists = new ArrayList<Sales_table2>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Sales_table2 bean = new Sales_table2();
				
							 				 
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
/*
	public Stu_fee SelectDataByPk( int no ){
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		
		String sql = " select * from Stu_fees " ;
		sql += " where no = ? " ;
		
		Stu_fee bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setInt( 1, no ); 
			
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				bean = new Stu_fee();
				bean.setContent(rs.getString("content"));
				bean.setWriter(rs.getString("writer"));
				bean.setDepth(rs.getInt("depth"));
				bean.setGroupno(rs.getInt("groupno"));
				bean.setNo(rs.getInt("no"));
				bean.setOrderno(rs.getInt("orderno"));
				bean.setPassword(rs.getString("password"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setRemark(rs.getString("remark"));
				bean.setSubject(rs.getString("subject"));
				
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
	*/
	public List<Sales_table2> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select inputdate, class_name, name, sales, return, remark, payno, salesno ";
		sql += " from (select a.inputdate, d.class_name, c.name, a.sales, a.return, ";
		sql	+= " a.payno, a.salesno, a.remark,rank() over ";
		sql += " (order by inputdate desc, class_name asc, name asc) as ranking ";
		sql += " from ";
		sql += " sales_table a left outer join stu_fee b ";
		sql += " on a.payno = b.payno ";
		sql += " left outer join student c ";
		sql += " on b.sid = c.sid ";
		sql += " left outer join myclass d ";
		sql += " on c.class_id = d.class_id ";
		
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
				sql += " ) ";
				sql += " order by ranking asc ";
					
		List<Sales_table2> lists = new ArrayList<Sales_table2>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			//pstmt.setInt(1, beginRow);
			//pstmt.setInt(2, endRow); 
			
			System.out.println(sql);	
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				Sales_table2 bean = new Sales_table2() ;
				if("".equals(rs.getString("class_name")) || rs.getString("class_name") == null) {
					bean.setClass_name("-");
				}else {
					bean.setClass_name(rs.getString("class_name"));
				}
				bean.setInputdate(String.valueOf(rs.getDate("inputdate")));
				
				if("".equals(rs.getString("name")) || rs.getString("name") == null) {
					bean.setName("-");
				}else {
					bean.setName(rs.getString("name"));
				}
				if(rs.getInt("payno") < 0) {
					bean.setPayno(0);
				}else {
					bean.setPayno(rs.getInt("payno"));
				}
				if("".equals(rs.getString("remark")) || rs.getString("remark") == null){
					bean.setRemark("-");
				}else {
					bean.setRemark(rs.getString("remark"));
				}
				if(rs.getInt("return") < 0) {
					bean.setReturns(0);
				}else {
					bean.setReturns(rs.getInt("return"));
				}
				if(rs.getInt("sales") < 0) {
					bean.setSales(0);
				}else {
					bean.setSales(rs.getInt("sales"));
				}
				bean.setSalesno(rs.getInt("salesno"));
				
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
		
		String sql = " select count(*) as cnt from ";
		sql += " sales_table a left outer join stu_fee b ";
		sql += " on a.payno = b.payno ";
		sql += " left outer join student c ";
		sql += " on b.sid = c.sid ";
		sql += " left outer join myclass d ";
		sql += " on c.class_id = d.class_id ";
		
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



