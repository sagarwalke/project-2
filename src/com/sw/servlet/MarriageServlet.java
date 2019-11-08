package com.sw.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MarriageServlet extends HttpServlet{
	/**
	 * 
	 */
	

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	PrintWriter pw=null;
	String name=null,tage=null,gender=null;
	int age=0;
	List<String> list=null;
	//get writer stream	
	pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	//read data from req object
	name=req.getParameter("name");
	tage=req.getParameter("age");
	gender=req.getParameter("gender");
	//form validation approch-1(server side)
		//creating list collection object
		list =new ArrayList();
	if(name.equals("") || name==null || name.length()==0) {
		list.add("Person name must be required...");
	}
	if(tage.equals("") || tage==null || tage.length()==0) {
		list.add("Person age must be required...");
	}
	else{
		try {
			age=Integer.parseInt(tage);
			if(age<1 || age>125)
				list.add("Person Age must be between 1 to 125...");
		}catch(Exception e) {
			list.add("Age must be Numaric...");
		}
		
	}
	//print error msg
	if(list.size()!=0) {
		for(String msg:list)
			pw.println("<h1 style='color:red;text-align:center'>"+msg+"</h1>");
		return;//goes to method caller i.e. Servlet container and  don't execute further logics
			//e
	}
	//write b.logic
	if(gender.equals("male"))
		if(age>=21){
			pw.println("<br/><br/><h1 style='color:green;text-align:center'>Mr/Ms. "+name+" Are You Eligible For Marriage....:)</h1>");
			pw.println("<br><br><br><br><br><br>");
			pw.println("<center><img style='text-align:center' src ='ok.png'/></center>");
	}
	else {
			pw.println("<br/><br/><h1 style='color:red;text-align:center'>Mr/Ms. "+name+" Are You Not Eligible For Marriage....:(</h1>");
			pw.println("<br><br><br><br><br><br>");
			pw.println("<center><img style='text-align:center' src='no.png'/></center>");
	}
	if(gender.equals("female"))
		if(age>=18){
			pw.println("<br/><br/><h1 style='color:green;text-align:center'>Mr/Ms. "+name+" Are You Eligible For Marriage....:)</h1>");
			pw.println("<br><br><br><br><br><br>");
			pw.println("<center><img style='text-align:center' src='ok.png'/></center>");
	}
	else {
			pw.println("<br/><br/><h1 style='color:red;text-align:center'>Mr/Ms. "+name+" Are You Not Eligible For Marriage....:(</h1>");
			pw.println("<br><br><br><br><br><br>");
			pw.println("<center><img style='text-align:center' src='no.png'/></center>");
	}
	pw.println("<a href='input.html'><img src='home.png'></a>");
	//close stream
	pw.close();
	}
}