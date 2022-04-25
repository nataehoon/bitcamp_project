package kids.board.timetable.model;

public class Timetable {
	private int time_id ;
	private int subject_code ;
	private int class_id ;
	private String time ;
	private String day ;
	private String remark ;
	private String tid ;
	
	public Timetable() {}

	

	/**
	 * @return the time_id
	 */
	public int getTime_id() {
		return time_id;
	}



	/**
	 * @param time_id the time_id to set
	 */
	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}



	public int getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(int subject_code) {
		this.subject_code = subject_code;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	


	/**
	 * @return the tid
	 */
	public String getTid() {
		return tid;
	}



	/**
	 * @param tid the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}



	@Override
	public String toString() {
		return "Timetable [time_id=" + time_id + ", subject_code=" + subject_code + ", class_id=" + class_id + ", time="
				+ time + ", day=" + day + ", remark=" + remark + ", tid=" + tid + "]";
	}



	
	
	
}
