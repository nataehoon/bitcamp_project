package kids.common.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.board.medicine.model.Medicine2;
import kids.board.re_home.model.Re_home;
import kids.management.reservation.model.Reservation;

public class ComboDao  extends SuperDao {

	public Medicine2 SelectMeData(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select c.mmno, c.tti, s.name "
				+ " from (select m.meno mmno, m.tid tti, p.sid ssi "
				+ " from (select * from medicine where meno = (select max(meno) from medicine where tid = ? )) m inner join parents p "
				+ " on m.pid = p.pid) c inner join student s "
				+ " on c.ssi = s.sid ";
		
		Medicine2 bean = null;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bean = new Medicine2();
				
				bean.setName(rs.getString("name"));
				bean.setMeno(rs.getInt("mmno"));
				bean.setTid(rs.getString("tti"));
				
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
		System.out.println(bean);
		return bean;
	}

	public Re_home SelectHoData(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select c.reno, c.tti, s.name "
				+ " from (select m.hono reno, m.tid tti, p.sid ssi "
				+ " from (select * from re_home where hono = (select max(hono) from re_home where tid = ? )) m inner join parents p "
				+ " on m.pid = p.pid) c inner join student s "
				+ " on c.ssi = s.sid ";
		
		Re_home bean = null;
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bean = new Re_home();
				
				bean.setName(rs.getString("name"));
				bean.setHono(rs.getInt("reno"));
				bean.setTid(rs.getString("tti"));
				
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
		System.out.println(bean);
		return bean;
	}

	public List<Reservation> SelectReData() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select ranking, rid, tid, status, res_date, name, remark from ( "
				+ " select rid, tid, status, res_date, name, remark, rank() over(order by rid desc) "
				+ " as ranking from reservation) where ranking between 1 and 3 ";
		
		List<Reservation> lists = new ArrayList<Reservation>();
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }
			pstmt = this.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reservation bean = new Reservation();
				
				String str = rs.getString("res_date");
				
				bean.setName(rs.getString("name"));
				bean.setTid(rs.getString("tid"));
				bean.setStatus(rs.getString("status"));
				bean.setRes_date(String.valueOf(rs.getDate("res_date")));
				bean.setRid(rs.getInt("rid"));
				bean.setRemark(rs.getString("remark"));
				
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
		System.out.println(lists);
		return lists;
	}
	
}
