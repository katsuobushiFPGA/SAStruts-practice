package org.seasar.sastruts.example.form;

import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
import org.seasar.struts.annotation.Required;

public class LoginForm {
	@Required
	@Maxlength(maxlength=10)
	public String id;

	@Required
	@Minlength(minlength=8)
	@Maxlength(maxlength=20)
	public String password;
}
