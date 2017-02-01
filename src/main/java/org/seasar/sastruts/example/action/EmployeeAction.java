package org.seasar.sastruts.example.action;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.EmployeeForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class EmployeeAction {

	@ActionForm
	@Resource
	protected EmployeeForm employeeForm;

	@Execute(validator=false, urlPattern="list")
	public String index() {
		employeeForm.number = new ArrayList<>();
		employeeForm.number.add("test");
		return "index.jsp";
	}

	@Execute(validator=false, urlPattern="detail/{empId}")
	public String detail() {
		return "detail.jsp";
	}
}
