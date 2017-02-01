package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.RequestForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class RequestAction {
	@Resource
	@ActionForm
	protected RequestForm requestForm;

	@Execute(validator=false, urlPattern="index")
	public String index() {
		return "index.jsp";
	}
}
