package kids.management.st_total.st_manage.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kids.board.notification_board.model.Notification_board;
import kids.common.model.SuperDao;
import kids.members.employees.model.Employees;

public class St_managementDao extends SuperDao {
	
		public int InsertData(St_management bean){
			PreparedStatement pstmt = null;
			String sql = " insert into st_manage (stno, sid, poop, healthy, medicine_id, attendance, regdate,sleep,condition,meal,height,weight,remark) ";
			sql += " values(stno_seq.nextval, ?,?,?,?,?,to_char(sysdate,'yyyy/mm/dd'),?,?,?,?,?,?) ";
			
				System.out.println(sql);
				int cnt = -99999;
				System.out.println(bean);
				try {
					if( conn == null ) { super.conn = super.getConnection();}
					conn.setAutoCommit(false);
					pstmt = super.conn.prepareStatement(sql);
					
					pstmt.setInt(1,bean.getSid());
					pstmt.setInt(2, bean.getPoop());
					pstmt.setString(3, bean.getHealthy());
					pstmt.setInt(4, bean.getMedicine_id());
					pstmt.setString(5, bean.getAttendance());
					pstmt.setString(6, bean.getSleep());
					pstmt.setString(7, bean.getCondition());
					pstmt.setString(8, bean.getMeal());
					pstmt.setString(9, bean.getHeight());
					pstmt.setString(10, bean.getWeight());
					pstmt.setString(11, bean.getRemark());
					
					cnt = pstmt.executeUpdate() ; 
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
		
		public List<Notification_board> getListByRecent(String pid, int class_id, int number){
			List<Notification_board> list = null;
			PreparedStatement pstmt = null;
			Notification_board bean = null;
			ResultSet rs = null;
			String sql = " select * from noti_no_board where ((pid = ? and class_id = ?) or (pid = ? and classid = ?)) ";
				sql	+= " and dailyno > (select MAX(dailyno) - ? from noti_no_board ) order by regdate ";
				
				try {
					if(conn == null) {super.conn = super.getConnection() ; }
					pstmt = conn.prepareStatement(sql) ;
					
					pstmt.setString(1, pid);
					pstmt.setInt(2, class_id);
					pstmt.setInt(3, class_id);
					pstmt.setString(4, pid);
					pstmt.setInt(5, number);
					
					rs = pstmt.executeQuery() ; 
					list = new ArrayList<Notification_board>();
					while(rs.next()) {
						bean = new Notification_board();
						
						bean.setChecks(rs.getString("checks"));
						bean.setClass_id(rs.getInt("class_id"));
						bean.setContents(rs.getString("contents"));
						bean.setDailyno(rs.getInt("dailyno"));
						bean.setImage(rs.getString("image"));
						bean.setPid(rs.getString("pid"));
						bean.setRegdate(rs.getString("regdate"));
						bean.setRemark(rs.getString("remark"));
						bean.setSend(rs.getInt("send"));
						
						list.add(bean);
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
				return list ;
		}
		
		public List<St_management> getList(){
			List<St_management> list = null;
			PreparedStatement pstmt = null;
			St_management2 bean = null;
			ResultSet rs = null;
			String sql = " select a.attendance, a.condition, a.healthy, a.meal, a.medicine_id, a.poop, ";
			sql += " a.regdate, a.remark, a.sid, a.sleep, a.stno, a.weight, a.height, b.name, c.class_name from ";
			sql += " (st_manage a join student b ";
			sql += " on a.sid = b.sid ";
			sql += " join myclass c ";
			sql += " on b.class_id = c.class_id) ";
			sql += " order by stno desc ";
				
				try {
					if(conn == null) {super.conn = super.getConnection() ; }
					pstmt = conn.prepareStatement(sql) ;
					
					
					rs = pstmt.executeQuery() ; 
					list = new ArrayList<St_management>();
					while(rs.next()) {
						bean = new St_management2();
						bean.setAttendance(rs.getString("attendance"));
						bean.setCondition(rs.getString("condition"));
						bean.setHealthy(rs.getString("healthy"));
						bean.setMeal(rs.getString("meal"));
						bean.setMedicine_id(rs.getInt("medicine_id"));
						bean.setPoop(rs.getInt("poop"));
						bean.setRegdate(String.valueOf(rs.getDate("regdate")));
						bean.setRemark(rs.getString("remark"));
						bean.setSid(rs.getInt("sid"));
						bean.setSleep(rs.getString("sleep"));
						bean.setStno(rs.getInt("stno"));
						bean.setWeight(rs.getString("weight"));
						bean.setHeight(rs.getString("height"));
						bean.setName(rs.getString("name"));
						bean.setClass_name(rs.getString("class_name"));
						list.add(bean);
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
				return list ;
		}
		public List<St_management> getListById(int sid){
			List<St_management> list = null;
			PreparedStatement pstmt = null;
			St_management bean = null;
			ResultSet rs = null;
			
			String sql = " select * from st_manage where sid = ? order by stno desc ";
				
				try {
					if(conn == null) {super.conn = super.getConnection() ; }
					pstmt = conn.prepareStatement(sql) ;
					
					pstmt.setInt(1, sid);
					
					rs = pstmt.executeQuery() ; 
					list = new ArrayList<St_management>();
					while(rs.next()) {
						bean = new St_management();
						bean.setAttendance(rs.getString("attendance"));
						bean.setCondition(rs.getString("condition"));
						bean.setHealthy(rs.getString("healthy"));
						bean.setMeal(rs.getString("meal"));
						bean.setMedicine_id(rs.getInt("medicine_id"));
						bean.setPoop(rs.getInt("poop"));
						bean.setRegdate(String.valueOf(rs.getDate("regdate")));
						bean.setRemark(rs.getString("remark"));
						bean.setSid(rs.getInt("rs"));
						bean.setSleep(rs.getString("sleep"));
						bean.setStno(rs.getInt("stno"));
						bean.setWeight(rs.getString("weight"));
						bean.setHeight(rs.getString("height"));
						list.add(bean);
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
				return list ;
		}
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
					bean = new Employees() ;
					
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

		
		public Employees SelectDataByPk(String id) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = " select * from employees ";
			sql += " where tid = ? ";
			
			Employees bean = null;
			
			try {
				if(this.conn == null) {this.conn = this.getConnection();}
				pstmt = this.conn.prepareStatement(sql);
				
				pstmt.setString(1, id);
				
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
		
	}

