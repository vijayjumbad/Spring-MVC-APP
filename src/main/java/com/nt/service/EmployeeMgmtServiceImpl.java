package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.iEmployeeDAO;
import com.nt.dto.EmployeeDTO;
@Service("empService")
public class EmployeeMgmtServiceImpl implements iEmployeeMgmtService {
	@Autowired
	iEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchAllEmp() {
		List<EmployeeBO>listbo=null;
		List<EmployeeDTO>listdto=new ArrayList();
		// use dao
		listbo=dao.getAllEmp();
		//copy each bo to each dto
		listbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listdto.size()+1);
			dto.setGrosSalary(dto.getSalary()+dto.getSalary()*0.3f);
			dto.setNetSalary(dto.getGrosSalary()-dto.getGrosSalary()*0.2f);
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public String saveEmp(EmployeeDTO dto) {
		int result=0;
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use dao
		result=dao.addEmployee(bo);
		/*if(result==0)
			return"registration succed";
		else
			return"registration not succed";*/
		return result!=0?"registration not succeded":"registration not succeded";
	}

	@Override
	public String removeEmpById(int id) {
		int count=0;
		count=dao.deleteEmpById(id);
		return count==0?"record not deleted":"record  deleted";
	}

	@Override
	public EmployeeDTO fetchEmpById(int id) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		bo=dao.getEmpById(id);
		dto=new EmployeeDTO();
		// convert bo to dto
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String modifyEmpById(EmployeeDTO dto) {
		System.out.println(dto);
		int result=0;
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		result=dao.updateEmp(bo);
		return result==0?"record not updates":"record is updates";
	}

}
