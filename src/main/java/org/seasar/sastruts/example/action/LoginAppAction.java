package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.annotation.Auth;
import org.seasar.sastruts.example.dto.UserDto;
import org.seasar.sastruts.example.form.LoginAppForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

public class LoginAppAction {
	@Resource
	@ActionForm
	protected LoginAppForm loginAppForm;

	@Resource
	public UserDto userDto;

	@Execute(validator=false)
	public String index(){
		return "loginAppForm.jsp";
	}

	@Execute(validator=false)
	public String logout(){
		userDto.userName = null;
		return "loginAppForm.jsp";
	}

	@Execute(validator=true, input="loginAppForm.jsp")
	public String login(){
		if(loginAppForm.userName.equals("admin") && loginAppForm.password.equals("admin")){
			// ログイン成功
			userDto.userName = loginAppForm.userName;

			return "/loginApp/?redirect=true";

		} else {
			// ログイン失敗
			throw new ActionMessagesException("ユーザ名かパスワードのどちらかが違います。", false);
		}
	}

	@Auth
	@Execute(validator=false)
	public String auth(){
		return "auth.jsp";
	}
}
