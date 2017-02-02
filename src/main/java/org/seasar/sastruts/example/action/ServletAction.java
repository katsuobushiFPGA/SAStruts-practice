package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.dto.SampleDto;
import org.seasar.sastruts.example.form.ServletForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class ServletAction {
	@Resource
	public SampleDto sampleDto;

	@Resource
	@ActionForm
	protected ServletForm servletForm;

	@Execute (validator=false)
	public String index() {
		return "index.jsp";
	}

	public String resUserName;
	public long resUserId;

	/*
	 *登録確認画面処理
	 */
	@Execute (validator=true,input="index.jsp")
	public String confirm() {
		this.sampleDto.userId = this.servletForm.userId;
		this.sampleDto.userName = this.servletForm.userName;
		//確認画面に遷移
		return "confirm.jsp";
	}

	/*
	 *登録処理
	 */
	@Execute (validator=false)
	public String register() {
		System.out.println("reg message :" + sampleDto.userId);
		System.out.println("reg message :" + sampleDto.userName);

		//完了画面に遷移
		return "complete?redirect=true";
	}

	/*
	 *完了画面
	 */
	@Execute(validator=false)
	public String complete() {
		resUserId = sampleDto.userId;
		resUserName = sampleDto.userName;
		//完了画面を表示
		return "complete.jsp";
	}
}
