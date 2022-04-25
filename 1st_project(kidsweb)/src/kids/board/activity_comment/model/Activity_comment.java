package kids.board.activity_comment.model;

import java.util.Date;

public class Activity_comment {
		private int activity_cmid ;
		private int actino ;
		private String content ;
		private String regdate ;
		private String remark ;
		private String tid ;
		private String pid ;
		private int groupno ;
		private int orderno ;
		private int depth ;
		
		public Activity_comment() {}

		public int getActivity_cmid() {
			return activity_cmid;
		}

		public void setActivity_cmid(int activity_cmid) {
			this.activity_cmid = activity_cmid;
		}

		public int getActino() {
			return actino;
		}

		public void setActino(int actino) {
			this.actino = actino;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		

		/**
		 * @return the regdate
		 */
		public String getRegdate() {
			return regdate;
		}

		/**
		 * @param regdate the regdate to set
		 */
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getTid() {
			return tid;
		}

		public void setTid(String tid) {
			this.tid = tid;
		}

		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		public int getGroupno() {
			return groupno;
		}

		public void setGroupno(int groupno) {
			this.groupno = groupno;
		}

		public int getOrderno() {
			return orderno;
		}

		public void setOrderno(int orderno) {
			this.orderno = orderno;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Activity_comment [activity_cmid=" + activity_cmid + ", actino=" + actino + ", content=" + content
					+ ", regdate=" + regdate + ", remark=" + remark + ", tid=" + tid + ", pid=" + pid + ", groupno="
					+ groupno + ", orderno=" + orderno + ", depth=" + depth + "]";
		}
		
		
		
		
		

}
