package com.nt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.EmployeeDTO;
import com.nt.model.EmployeeModel;
import com.nt.service.iEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller("empController")
public class EmployeeController {
	@Autowired
	iEmployeeMgmtService service;
	@Autowired
	EmployeeValidator validator;
	@GetMapping("welcome.htm")
	public String showEmp()
	{
		return"home";
	}
	@GetMapping("show_emp.htm")
	public String fetchEmp(Map<String, Object>map)
	{
		List<EmployeeDTO>listdto=null;
		//get service class obj
		listdto=service.fetchAllEmp();
		//keep in model attr
		map.put("resultMsg", listdto);
		return "result";
	}
           @GetMapping("add.htm")	
        public String registerEmployee(@ModelAttribute("empfrm") EmployeeModel emp)
        {
        	return "save_form";
        }
           @PostMapping("add.htm")
           public String addEmployee(RedirectAttributes redirect,@ModelAttribute("empfrm") EmployeeModel emp,BindingResult error)
           {
        	   String result=null;
        	   EmployeeDTO dto=null;
        	   //convert model date to dto
        	   dto=new EmployeeDTO();
        	   //perform server enable server side form validation when client side validation are nt done
        		//read vflag value
        	   if(emp.getVflag().equalsIgnoreCase("no"))
        	   {
        	   if(validator.supports(EmployeeModel.class))
        		   validator.validate(emp, error);
        	   }
        	   if(error.hasErrors())
        		   return "save_form";

       
        	   BeanUtils.copyProperties(emp,dto);
        	   //use service
        	   result=service.saveEmp(dto);
        	   //keep int model attr
        	    redirect.addFlashAttribute("resultMsg",result);
        	  
			return "redirect:show_emp.htm";
        	   
           }
           @GetMapping("delete_emp.htm")
           public String removeEmp(@RequestParam int eno,RedirectAttributes redirect)
           {
        	   String result=null;
        	   result=service.removeEmpById(eno);
        	   //use PRG(post redirecting get)
        	   redirect.addFlashAttribute("resultMsg",result);
			return "redirect:show_emp.htm";
        	   
           }
           @GetMapping("edit_emp.htm")
           public String GetEmpById(@ModelAttribute("empfrm") EmployeeModel emp,@RequestParam int eno) {
        	   EmployeeDTO dto=null;
        	   dto=service.fetchEmpById(eno);
        	   //convert dto to model 
        	   BeanUtils.copyProperties(dto,emp);
			return "update_emp";
        	   }
           @PostMapping("edit_emp.htm")
           public String updateEmployee(RedirectAttributes redirect,@ModelAttribute("empfrm") EmployeeModel emp,BindingResult error) {
			EmployeeDTO dto=null;
			String result=null;
			dto=new EmployeeDTO();
			//perform server side validation
     	   if(validator.supports(EmployeeModel.class))
     		   validator.validate(emp, error);
     	   if(error.hasErrors())
     		   return "update_emp";
			//convert model to dto
			BeanUtils.copyProperties(emp,dto);
			//use service
			result=service.modifyEmpById(dto);
			//add flash attr.
			redirect.addFlashAttribute("resultMsg",result);
			//redirect req
        	  return "redirect:show_emp.htm";
        	   
           }
           
           @ModelAttribute("addrses")
           public List<String> GetAddrsesList(@ModelAttribute EmployeeModel emp)
           {
        	 List<String>addrses=new ArrayList();
        	 addrses.add("hyd");
        	 addrses.add("jalna");
        	 addrses.add("pune");
        	 addrses.add("a.bad");
        	 addrses.add("mumbai");
			return addrses;
        	  
        	   
           }
}
