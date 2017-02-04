package org.seasar.sastruts.example.form;

import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Required;

public class ValidationEchoForm {
	@Required
	@Maxlength(maxlength=10)
	public String name;

	@Required
	@IntegerType
	public String age;

	public String[] products;

}
