package com.nt.bo;

public class EmployeeBO {
	private int empNo;
	private String eName;
	private String addrs;
	private float salary;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeBO [empNo=" + empNo + ", eName=" + eName + ", addrs=" + addrs + ", salary=" + salary + "]";
	}
	
	
}
