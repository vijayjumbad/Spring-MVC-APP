
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:red;text-align:center">update Employee form</h1>
<script language="JavaScript"  src="js/validation.js">
</script>

<frm:form method="POST" modelAttribute="empfrm" onsubmit="return validate(this)">
<table align="center" bgcolor="saffron">
<tr>
  <td>Emp No::</td>
  <td><frm:input path="empNo" readonly="true"/></td>
  </tr>
  <tr>
  <td>EmpName::</td>
  <td><frm:input path="eName"/><frm:errors cssStyle="color:red" path="eName"/> <span id="nameError"></span></td>
  </tr>
  <tr>
  <td>Emp Addrs::</td>
  <td><frm:select path="addrs">
           <frm:options items="${addrses}"/>
  </frm:select>
  </tr>
  <tr>
  <td>Emp salary::</td>
  <td><frm:input path="salary"/><frm:errors cssStyle="color:red" path="salary"/><span id="salaryError"></span></td>
  </tr>
  <tr>
  <td><frm:hidden path="vflag"/></td>
  <td><input type="submit" value="update employee"></td>
  </tr>
</frm:form>
</table>