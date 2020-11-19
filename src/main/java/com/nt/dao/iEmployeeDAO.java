package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface iEmployeeDAO {
	public List<EmployeeBO> getAllEmp();
	public int addEmployee(EmployeeBO bo);
	public int deleteEmpById(int id);
	public EmployeeBO getEmpById(int id);
	public int updateEmp(EmployeeBO bo);

}
