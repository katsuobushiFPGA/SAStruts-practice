package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.sastruts.example.form.ValidationMethodForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;
import org.seasar.struts.util.RequestUtil;

public class ValidationMethodAction {
	private String[] testId = {"2233","2344","223"};

	@Resource
	@ActionForm
	protected ValidationMethodForm validationMethodForm;

	@Execute (validator=false,removeActionForm = true)
	public String index() {
		return "index.jsp";
	}

	@Execute (validate="validate",input="index.jsp")
	public String confirm() {
		//ユーザIDが重複していないか確認
		for(int i=0;i<testId.length;i++) {
			if(validationMethodForm.id.equals(testId[i])) {
		       //エラーメッセージをセットします。
		        ActionMessages errors = new ActionMessages();
		        errors.add("id", new ActionMessage(
		            "labels.dupId", //メッセージリソースファイルに定義してあるキーです。
		            new Object[] { validationMethodForm.id }));
		        ActionMessagesUtil.addErrors(RequestUtil.getRequest(), errors);
		        return "index.jsp";
//				throw new ActionMessagesException("ユーザIDはすでに使用されています", false);
			}
		}
		return "confirm.jsp";
	}

	/*
	 *ユーザ登録メソッド
	 */
	@Execute(validator=false)
	public String register() {
		return "complete?redirect=true";
	}

	/**
	 * 完了画面
	 */
	@Execute(validator=false)
	public String complete() {
		return "complete.jsp";
	}

	/**
	 * リセットメソッド
	 */
	public void reset() {
		validationMethodForm = null;
	}
}
