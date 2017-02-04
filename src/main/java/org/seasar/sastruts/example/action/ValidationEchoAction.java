package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.ValidationEchoForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class ValidationEchoAction {
	@Resource
	@ActionForm
	protected ValidationEchoForm validationEchoForm;

	@Execute (validator=false)
	public String index() {
		return "index.jsp";
	}

	@Execute (validator=true,input="index.jsp")
	public String confirm() {
		return "confirm.jsp";
	}

	/**
	 * リセットメソッド
	 */
	public void reset() {
		validationEchoForm = null;
	}

}
