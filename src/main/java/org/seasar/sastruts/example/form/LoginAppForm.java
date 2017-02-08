package org.seasar.sastruts.example.form;

import org.seasar.struts.annotation.Required;

public class LoginAppForm {
		@Required
		public String userName;

		@Required
		public String password;
}
