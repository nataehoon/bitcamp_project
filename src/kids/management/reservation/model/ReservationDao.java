package kids.management.reservation.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.common.model.SuperDao;
import kids.members.parents.model.ParentsMiniView;

public class ReservationDao extends SuperDao {

	public int SelectTotalCount(String year, String month, String order, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select count(*) as cnt from reservation ";
			   sql += " where to_char(res_date,'yyyy') = ? and";
			   sql += " to_char(res_date,'MM') = ?  and status = '상담대기'";
				if(!keyword.equalsIgnoreCase("all")) {
					sql +=" and (name like '%'||?||'%' or hp like '%'||?||'%') ";
				}
			   sql += " order by res_date "+order;
	    int cnt = 0;
	   try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			System.out.println("sql : "+sql);
			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			if(!keyword.equalsIgnoreCase("all")){
				pstmt.setString(3, keyword);
				pstmt.setString(4, keyword);
			}
			rs = pstmt.executeQuery() ;
			
			if(rs.next()) {
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
		return cnt ;	
	}

	public List<Reservation> selectDataList(int beginRow, int endRow, String year, String month, String order,
			String keyword) {
		List<Reservation> rlists = new ArrayList<Reservation>();
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select ranking, rid, tid, textarea, status, res_date, reg_date, name, hp";
			   sql += " from (select rid, tid, textarea, status, res_date, reg_date, name, hp,";
			   sql += " rank() over(order by res_date "+order+") as ranking from reservation";
			   sql += " where to_char(res_date,'yyyy') = ? and";
			   sql += " to_char(res_date,'MM') = ? ";
				if(!keyword.equalsIgnoreCase("all")) {
					sql +=" and (name like '%'||?||'%' or hp like '%'||?||'%') and status = '상담대기' ";
				}
			   sql += " ) where ranking between ? and ?";
		   
	   try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			System.out.println("sql : "+sql);
			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			if(!keyword.equalsIgnoreCase("all")){
				pstmt.setString(3, keyword);
				pstmt.setString(4, keyword);
				pstmt.setInt(5, beginRow);
				pstmt.setInt(6, endRow);
			}else {
				pstmt.setInt(3, beginRow);
				pstmt.setInt(4, endRow);
			}
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				Reservation bean = new Reservation();
				bean.setHp(rs.getString("hp"));
				bean.setName(rs.getString("name"));
				bean.setReg_date(String.valueOf(rs.getDate("reg_date")));
				bean.setRes_date(String.valueOf(rs.getDate("res_date")));
				bean.setRid(rs.getInt("rid"));
				bean.setStatus(rs.getString("status"));
				bean.setTextarea(rs.getString("textarea"));
				bean.setTid(rs.getString("tid"));
				
				rlists.add(bean);
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
		return rlists;
	}

	public boolean insertData(Reservation bean) {
		boolean check = false;
		PreparedStatement pstmt = null ;
		String sql = "insert into reservation (rid, status, res_date, reg_date, name, hp)"
				+ " values (rid_seq.nextval, '상담대기', ?, sysdate, ?, ?)";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, bean.getRes_date());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getHp());
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

	public List<Reservation> selectDataAfterList(int beginRow, int endRow, String year, String month, String order,
			String keyword) {
		List<Reservation> rlists = new ArrayList<Reservation>();
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select rid, tid, textarea, status, res_date, reg_date, name, hp, remark, tname, ranking";
				sql += " from (select r.rid, r.tid, r.textarea, r.status, r.res_date, r.reg_date, r.name, r.hp, r.remark, e.name as tname, r.ranking";
				sql += " from (select rid, tid, textarea, status, res_date, reg_date, name, hp, remark,";
				sql += " rank() over(order by res_date "+order+") as ranking from reservation";
				sql += " where to_char(res_date,'yyyy') = ? and";
				sql += " to_char(res_date,'MM') = ? and status = '상담완료'";
				if(!keyword.equalsIgnoreCase("all")) {
					sql +=" and (name like '%'||?||'%' or hp like '%'||?||'%')";
				}
				sql += " ) r inner join employees e on r.tid = e.tid) where ranking between ? and ? ";
		
	   try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			System.out.println("sql : "+sql);
			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			if(!keyword.equalsIgnoreCase("all")){
				pstmt.setString(3, keyword);
				pstmt.setString(4, keyword);
				pstmt.setInt(5, beginRow);
				pstmt.setInt(6, endRow);
			}else {
				pstmt.setInt(3, beginRow);
				pstmt.setInt(4, endRow);
			}
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				Reservation bean = new Reservation();
				bean.setHp(rs.getString("hp"));
				bean.setName(rs.getString("name"));
				bean.setReg_date(String.valueOf(rs.getDate("reg_date")));
				bean.setRes_date(String.valueOf(rs.getDate("res_date")));
				bean.setRid(rs.getInt("rid"));
				bean.setStatus(rs.getString("status"));
				bean.setTextarea(rs.getString("textarea"));
				bean.setTid(rs.getString("tid"));
				bean.setTname(rs.getString("tname"));
				
				rlists.add(bean);
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
		return rlists;
	}

	public int SelectAfterTotalCount(String year, String month, String order, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select count(*) as cnt from reservation ";
			   sql += " where to_char(res_date,'yyyy') = ? and";
			   sql += " to_char(res_date,'MM') = ? and status = '상담완료'";
				if(!keyword.equalsIgnoreCase("all")) {
					sql +=" and (name like '%'||?||'%' or hp like '%'||?||'%') ";
				}
			   sql += " order by res_date "+order;
	    int cnt = 0;
	   try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			System.out.println("sql : "+sql);
			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			if(!keyword.equalsIgnoreCase("all")){
				pstmt.setString(3, keyword);
				pstmt.setString(4, keyword);
			}
			rs = pstmt.executeQuery() ;
			
			if(rs.next()) {
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
		return cnt ;	
	}

	public int deleteData(int rid) {
		int cnt = -99999;
		PreparedStatement pstmt = null ;
		String sql = "delete from reservation where rid = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setInt(1, rid);
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

	public Reservation selectDataByPk(int rid) {
		Reservation bean = null;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select * from reservation where rid = ?";
	   try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setInt(1, rid);
	
			rs = pstmt.executeQuery() ;
			
			if(rs.next()) {
				bean = new Reservation();
				bean.setHp(rs.getString("hp"));
				bean.setName(rs.getString("name"));
				bean.setReg_date(String.valueOf(rs.getDate("reg_date")));
				bean.setRes_date(String.valueOf(rs.getDate("res_date")));
				bean.setRid(rs.getInt("rid"));
				bean.setStatus(rs.getString("status"));
				bean.setTextarea(rs.getString("textarea"));
				bean.setTid(rs.getString("tid"));
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
		return bean ;	
	}

	public int update(Reservation bean) {
		int cnt = -99999;
		PreparedStatement pstmt = null ;
		String sql = "update reservation set name = ?, hp = ?, res_date = ?, tid = ?, textarea = ?, reg_date = ?, status = ?"
				+ " where rid = ?";
		
		try {
			if(conn == null) {super.conn = super.getConnection() ; }
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getHp());
			pstmt.setString(3, bean.getRes_date());
			pstmt.setString(4, bean.getTid());
			pstmt.setString(5, bean.getTextarea());
			pstmt.setString(6, bean.getReg_date());
			pstmt.setString(7, bean.getStatus());
			pstmt.setInt(8, bean.getRid());
			
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


}
