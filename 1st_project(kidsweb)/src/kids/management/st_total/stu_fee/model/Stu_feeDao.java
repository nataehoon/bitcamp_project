package kids.management.st_total.stu_fee.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;


public class Stu_feeDao extends SuperDao {

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
	public int InsertData( int payno, int remark ){ //state 분납일 때 실
		String sql = " update stu_fee set month = to_char(sysdate,'mm/dd'), unpaid = 10000 - ? , remark = ?, state='분납' ";
		sql += " where payno = ? ";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, remark);
			pstmt.setInt(2, remark);
			pstmt.setInt(3, payno);
		
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
	public int UpdateData( int payno, int remark ){
		
		String sql = " insert into stu_fee (payno, sid, month, unpaid, remark, state) ";
		sql += " values(payno_seq.nextval, ";
		sql += " (select sid from stu_fee where payno = ?), ";
		sql += " to_char(sysdate,'mm/dd'),(select unpaid from stu_fee where payno = ?) - ?,?,'분납') ";
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
				pstmt.setInt(1, payno);
				pstmt.setInt(2, payno);
				pstmt.setInt(3, remark);
				pstmt.setInt(4, remark);
				
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
	public int UpdateData( String[] payno ){
		String sql = " update stu_fee set unpaid = 0, month = to_char(sysdate,'mm/dd'), state = '완납' ";
		sql	+= " where payno = ? " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			for(String num : payno) {
				pstmt.setInt(1, Integer.parseInt(num));
				
				cnt = pstmt.executeUpdate() ; 
				conn.commit(); 
			}
			
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
	public List<Stu_fee> SelectDataList() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " " ;
		sql += " " ;
		sql += " " ;
		
		List<Stu_fee> lists = new ArrayList<Stu_fee>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Stu_fee bean = new Stu_fee();
				
							 				 
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

	public int SelectDataByPk( String[] payno ){
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		
		String sql = " select * from Stu_fee " ;
		sql += " where payno = ? and state = '분납' " ;
		
		int cnt = -99999;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			for(String a : payno) {
				pstmt.setInt( 1, Integer.parseInt(a) ); 
				
				rs = pstmt.executeQuery() ; 
				
				if ( rs.next() ) { 
					cnt = 1;
				}
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
		return cnt;
	}
	
	public List<Stu_fee2> SelectDataList(int beginRow, int endRow, String month, String paid, String class_name ) {
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = " select payno, name, class_name, remark, month,state, unpaid, ranking ";
		sql += " from (select b.payno, a.name, c.class_name, b.remark, b.month,b.state, b.unpaid, ";
		sql += " rank() over(order by  b.payno desc, c.class_name asc, b.unpaid asc) as ranking ";
		sql += " from stu_fee b join student a ";
		sql += " on b.sid = a.sid join myclass c ";
		sql += " on a.class_id = c.class_id ";
		
			if(month.equals("all") && paid.equals("all")&& class_name.equals("all")) {// 전체 검색
//				sql += " where month like to_char(sysdate,'mm') || '%' ";
			}
			else { sql += " where ";
				
			if(month.equals("all") == false) {
					sql += "month like ('"+ month +"%') ";
					if(paid.equals("all") == false) {
							sql += " and state ='" + paid + "' ";
						if(class_name.equals("all") == false) {
							sql += " and class_name = ('"+ class_name +"') ";
						}//class_name값 있음
						else {
							
						}
					}//paid 값 있음
						else {
							if(class_name.equals("all") == false) {
								sql += " and class_name = ('"+ class_name +"') ";
							}else {
							}
						}// paid 값 없음
					}//month값 있음
						else {
						if(paid.equals("all") == false) {
							sql += " state ='" + paid + "' ";
							if(class_name.equals("all") == false) {
								sql += " and class_name = ('"+ class_name +"') ";
							}else {
							}
						}//paid값 있음
							else {
							if(class_name.equals("all")== false) {
								sql += " class_name = ('"+ class_name +"') ";
							}//class_name 있음
							else {
							}//class_name 없음
					}//month값 없음
				}
			}
				sql += " ) ";
				sql += " where ranking between ? and ? ";
					
		List<Stu_fee2> lists = new ArrayList<Stu_fee2>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;	
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow); 
			
			System.out.println(sql);	
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				Stu_fee2 bean = new Stu_fee2() ; 
				bean.setClass_name(rs.getString("class_name"));
				bean.setMonth(rs.getString("month"));
				bean.setName(rs.getString("name"));
				bean.setPaid(rs.getString("state"));
				bean.setRemark(rs.getString("remark"));
				bean.setUnpaid(rs.getInt("unpaid"));
				bean.setPayno(rs.getInt("ranking"));
				bean.setPayno(rs.getInt("payno"));
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
	public int SelectTotalCount(String month, String paid, String class_name) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select count(*) as cnt " ;
		sql	+= " from stu_fee b join student a";
		sql	+= " on b.sid = a.sid join myclass c";
		sql	+= " on a.class_id = c.class_id ";
		
		if(month.equals("all") && paid.equals("all")&& class_name.equals("all")) {// 전체 검색
//			sql += " where month like to_char(sysdate,'mm') || '%' ";
		}
		else { sql += " where ";
			
		if(month.equals("all") == false) {
				sql += "month like ('"+ month +"%') ";
				if(paid.equals("all") == false) {
						sql += " and state ='" + paid + "' ";
					if(class_name.equals("all") == false) {
						sql += " and class_name = ('"+ class_name +"') ";
					}//class_name값 있음
					else {
						
					}
				}//paid 값 있음
					else {
						if(class_name.equals("all") == false) {
							sql += " and class_name = ('"+ class_name +"') ";
						}else {
						}
					}// paid 값 없음
				}//month값 있음
					else {
					if(paid.equals("all") == false) {
						sql += " state ='" + paid + "' ";
						if(class_name.equals("all") == false) {
							sql += " and class_name = ('"+ class_name +"') ";
						}else {
						}
					}//paid값 있음
						else {
						if(class_name.equals("all")== false) {
							sql += " class_name = ('"+ class_name +"') ";
						}//class_name 있음
						else {
						}//class_name 없음
				}//month값 없음
			}
		}
			sql += " ) ";
			sql += " where ranking between ? and ? ";
				
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

	public int SelectDataByPk(String a) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		
		String sql = " select * from Stu_fee " ;
		sql += " where payno = ? and state = '분납' " ;
		
		int cnt = -99999;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
				pstmt.setInt( 1, Integer.parseInt(a) ); 
				
				rs = pstmt.executeQuery() ; 
				
				if ( rs.next() ) { 
					cnt = 1;
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
		return cnt;
	}
	}



