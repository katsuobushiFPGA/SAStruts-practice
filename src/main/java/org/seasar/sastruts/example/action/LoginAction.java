package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.LoginForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

public class LoginAction {
	@ActionForm
	@Resource
	protected LoginForm loginForm;


	public String[] usedId = {"1111","2222","3333","4444"};
	public String[] dictPass = {"password","1111","2222","3333"};

	/*
	 *ログイン画面
	 */
	@Execute (validator=false)
	public String index() {
		//入力画面を表示
		return "index.jsp";
	}

	/*
	 *ログイン成功画面
	 */
	@Execute (validator=true,input="index.jsp")
	public String login() {
		//DB
		for(String id : usedId) {
			if(id.equals(loginForm.id)) {
				throw new ActionMessagesException("すでに使用されているIDです。", false);
			}
		}
		for(String pass:dictPass) {
			if(pass.equals(loginForm.password)) {
				throw new ActionMessagesException("単純なパスワードです!", false);
			}
		}
		//確認画面に遷移
		return "login.jsp";
	}
}
