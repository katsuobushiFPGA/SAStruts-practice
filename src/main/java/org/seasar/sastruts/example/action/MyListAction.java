package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.framework.aop.annotation.Trace;
import org.seasar.sastruts.example.form.MyListForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class MyListAction {
	@Resource
	@ActionForm
	public MyListForm myListForm;

	@Trace
    @Execute(validator = false)
	public String index() {
        return "index.jsp";
	}

	@Execute(validator=true,input="index.jsp")
	public String confirm() {
		return "confirm.jsp";
	}


}
