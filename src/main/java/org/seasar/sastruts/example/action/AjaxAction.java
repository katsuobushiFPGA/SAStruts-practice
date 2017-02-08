package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.AjaxForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

public class AjaxAction {
	/* アクションフォーム */
	@Resource
	@ActionForm
	protected AjaxForm ajaxForm;

	@Execute(validator=false)
	public String index() {
		return "index.jsp";
	}

	@Execute(validator=false)
	public String hello() {
		ResponseUtil.write("こんにちは");
		return null;
	}

}
