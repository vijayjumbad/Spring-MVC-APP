package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private int srNo;
	private int empNo;
	private String eName;
	private String addrs;
	private float salary;
	private float grosSalary;
	private float netSalary;
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
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
	public float getGrosSalary() {
		return grosSalary;
	}
	public void setGrosSalary(float grosSalary) {
		this.grosSalary = grosSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [srNo=" + srNo + ", empNo=" + empNo + ", eName=" + eName + ", addrs=" + addrs + ", salary="
				+ salary + ", grosSalary=" + grosSalary + ", netSalary=" + netSalary + "]";
	}
	
	
	

}
