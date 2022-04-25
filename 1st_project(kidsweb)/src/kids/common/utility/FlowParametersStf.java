package kids.common.utility;

public class FlowParametersStf extends FlowParameters {
	private String month;
	private String paid;
	private String class_name;
	private int pageSize;
	
	@Override
	public String toString() {
		return "FlowParametersStf [month=" + month + ", paid=" + paid + ", class_name=" + class_name + ", pageSize="
				+ pageSize + "]";
	}

	public FlowParametersStf(String pageNumber, String month, String paid, String class_name, String pageSize) {
		// TODO Auto-generated constructor stub
		super(pageNumber,null,null);
		if(month == null || month.equals("") || month.equals("null")) {
			this.month = "all";
		}else {
			this.month = month;
		}
		if(paid == null || paid.equals("") || paid.equals("null")) {
			this.paid = "all";
		}else {
			this.paid = paid;
		}
		if(class_name == null || class_name.equals("") || class_name.equals("null")) {
			this.class_name = "all";
		}else {
			this.class_name = class_name;
		}
		if(pageSize == null || pageSize.equals("") || pageSize.equals("null")) {
			this.pageSize = 10;
		}else {
			this.pageSize = Integer.parseInt(pageSize);
		}
		
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
	
	
}
