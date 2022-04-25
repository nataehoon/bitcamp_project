package kids.management.myclass.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.members.student.model.Student;

public class MyclassDao extends SuperDao{
	public int DeleteData (int class_id){
		String sql = " delete from myclass where class_id = ? " ;
		
		PreparedStatement pstmt = null ;
	
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setInt(1, class_id);

			cnt = pstmt.executeUpdate() ;			
			conn.commit();
		} catch (Exception e) {			
						
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

	private Student SelectDataByPk(int class_id) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;	
		
		String sql = " select * from myclass " ;
		sql += " where class_id = ? " ;
		
		Student bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			pstmt.setInt(1, class_id);
			
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

	public List<Myclass> SelectDataList() {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select * from myclass order by class_id desc" ;
		
		List<Myclass> lists = new ArrayList<Myclass>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
			rs = pstmt.executeQuery() ;			
			
			while( rs.next() ){
				Myclass bean = new Myclass();
				
				bean.setClass_id(rs.getInt("class_id"));
				bean.setClass_name(rs.getString("class_name"));
				bean.setRemark(rs.getString("remark"));
											 				 
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

	public int insertData(Myclass bean) {
		String sql = " insert into myclass(class_id, class_name, remark) " ;
		sql += " values(myclass_id_seq.nextval, ?, ?) " ;
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getClass_name());
			pstmt.setString(2, bean.getRemark());
			
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

	public int UpdateData( Myclass bean ){
		String sql = " update Myclass set class_name = ?, remark = ? where class_id = ? " ;
		
		
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getClass_name());
			pstmt.setString(2, bean.getRemark());
			pstmt.setInt(3, bean.getClass_id());
			
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

	public List<Myclass> selectDataList() {
		List<Myclass> clists = new ArrayList<Myclass>();
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "select * from myclass";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Myclass bean = new Myclass();
				bean.setClass_id(rs.getInt("class_id"));
				bean.setClass_name(rs.getString("class_name"));
				bean.setRemark("remark");
				
				clists.add(bean);
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
		return clists;
	}


}
