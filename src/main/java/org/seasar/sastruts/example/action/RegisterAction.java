package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.RegisterForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class RegisterAction {
	@ActionForm
	@Resource
	protected RegisterForm registerForm;

	/*
	 *入力画面
	 */
	@Execute (validator=false)
	public String input() {
		//入力画面を表示
		return "input.jsp";
	}

	/*
	 *登録確認画面処理
	 */
	@Execute (validator=true,input="input.jsp")
	public String confirm() {
		//確認画面に遷移
		return "confirm.jsp";
	}

	/*
	 *登録処理
	 */
	@Execute (validator=false,input="confirm.jsp")
	public String register() {
		//登録処理
		System.out.println("reg message :" + this.registerForm.message);

		//完了画面に遷移
		return "complete?redirect=true";
	}

	/*
	 *完了画面
	 */
	@Execute(validator=false)
	public String complete() {
		//完了画面を表示
		return "complete.jsp";
	}
}
