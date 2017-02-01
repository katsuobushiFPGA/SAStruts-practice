package org.seasar.sastruts.example.action;

import org.seasar.struts.annotation.Execute;

public class SampleAction {
	public String message;

	@Execute (validator=false)
	public String index() {
		this.message = "Hello,World";
		return "index.jsp";
	}
}
