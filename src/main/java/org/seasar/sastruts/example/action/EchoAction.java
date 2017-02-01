package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.framework.aop.annotation.Trace;
import org.seasar.sastruts.example.form.EchoForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class EchoAction {
	/* アクションフォーム */
	@Resource
	@ActionForm
	protected EchoForm echoForm;

	@Execute(validator=false)
	@Trace
	public String index() {
		System.out.println("Trace : EchoAction/index");
		return "input.jsp";
	}

	@Execute(validator=true, input="input.jsp")
	@Trace
	public String echo() {
		System.out.println("Trace : EchoAction/echo");
		return "echo.jsp";
	}

}
