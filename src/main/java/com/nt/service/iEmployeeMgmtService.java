package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface iEmployeeMgmtService {
	
	public List<EmployeeDTO> fetchAllEmp();
	public String saveEmp(EmployeeDTO dto);
	public String removeEmpById(int id);
	public EmployeeDTO fetchEmpById(int id);
	public String modifyEmpById(EmployeeDTO dto);
	

}
