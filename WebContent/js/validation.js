
function validate(frm){
	   alert("1");
	   //read formd data
	  var eName=frm.eName.value;
	  var salary=frm.salary.value;
	  var flag=true;
	  
	  document.getElementById("nameError").innerHTML=" ";
	  document.getElementById("salaryError").innerHTML="";
	  alert("2");
	  frm.vflag.value="yes";
	  if(eName=="")
		  {
		   document.getElementById("nameError").innerHTML="name is mandatory(js)";
		  frm.eName.focus();
		  return false;
		  }
	  else if(eName.length<4 ||eName.length>10)
			  {
		  alert("2");
		  document.getElementById("nameError").innerHTML="name min 4 or mx 10 chars(js)";
		  frm.eName.focus();
			  return false;
			  }
	     if(salary==""){
		   document.getElementById("salaryError").innerHTML="salary is mandatory(js)";
			  return false;
	         }
	     else  if(salary<10000||salary>100000){ 
			 //(sal<10000 || sal>100000)
			  document.getElementById("salaryError").innerHTML="salary min 10000 or max 100000(js)";
			  return false;
		  }
		   
	  else if(isNaN(salary)){
		  document.getElementById("salaryError").innerHTML="salary is not empty(js)";
		  return false;
	  }
	  
	  return flag;
}//function
