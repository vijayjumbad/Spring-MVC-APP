package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("empDAO")
public class EmployeeDAOImpl implements iEmployeeDAO {
	private static final String GET_ALL_EMPS="SELECT EMPNO,ENAME,EADDRS,SALARY FROM EMPLOYEE";
	private static final String INSERT_EMPS="INSERT INTO EMPLOYEE VALUES(SQU_EMP.NEXTVAL,?,?,?)";
	private static final String DELETE_EMPS_BY_ID="DELETE FROM EMPLOYEE WHERE EMPNO=?";
	private static final String GET__EMPS_BY_ID="SELECT EMPNO,ENAME,EADDRS,SALARY FROM EMPLOYEE WHERE EMPNO=?";
	private static final String Update__EMP_BY_ID="UPDATE EMPLOYEE SET ENAME=?,EADDRS=?,SALARY=? WHERE EMPNO=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmp() {
		List<EmployeeBO>listbo=null;
		listbo=jt.query(GET_ALL_EMPS, new EmployeeMapper());
		return listbo;
	}
	private class EmployeeMapper implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO>listbo=new ArrayList();
			//copy each rs to bo class obj
			while(rs.next()) {
				EmployeeBO bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.seteName(rs.getString(2));
			bo.setAddrs(rs.getString(3));
			bo.setSalary(rs.getInt(4));
			//copy bo to listbo
			listbo.add(bo);
			}
			
			return listbo;
		}
		
	}
	@Override
	public int addEmployee(EmployeeBO bo) {
		int result=0;
		 result=jt.update(INSERT_EMPS,bo.geteName(),bo.getAddrs(),bo.getSalary());
		 
		return result;
	}
	@Override
	public int deleteEmpById(int id) {
		int count=0;
		count=jt.update(DELETE_EMPS_BY_ID,id);
		return count;
	}
	@Override
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET__EMPS_BY_ID,new EmployeeRowMapper1() , id);
		return bo;
	}
	//inner class
	private static class EmployeeRowMapper1 implements RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBO bo=null;
			bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.seteName(rs.getString(2));
			bo.setAddrs(rs.getString(3));
			bo.setSalary(rs.getFloat(4));
			return bo;
		}
		
	}
	@Override
	public int updateEmp(EmployeeBO bo) {
		System.out.println(bo);
		int count=0;
		count=jt.update(Update__EMP_BY_ID,bo.geteName(),bo.getAddrs(),bo.getSalary(),bo.getEmpNo());
		return count;
	}

}
