 package kids.management.myclass.model;

public class Myclass {
	private int class_id ;
	private String class_name ;
	private String remark ;
	
	public Myclass() {}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Myclass [class_id=" + class_id + ", class_name=" + class_name + ", remark=" + remark + "]";
	}

	
	
}
