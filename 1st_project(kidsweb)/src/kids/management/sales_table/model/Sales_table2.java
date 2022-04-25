package kids.management.sales_table.model;

public class Sales_table2 extends Sales_table {
	private String class_name;
	private String name;
	
	public Sales_table2() {
		// TODO Auto-generated constructor stub
	}
	public Sales_table2(int salesno, int payno, String inputdate, int sales, int returns, String remark,String class_name, String name) {
		super(salesno, payno, inputdate, sales, returns, remark);
		this.class_name = class_name;
		this.name = name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
