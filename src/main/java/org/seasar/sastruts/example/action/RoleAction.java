package org.seasar.sastruts.example.action;

import org.seasar.struts.annotation.Execute;

public class RoleAction {
	/* admin ロールのみ実行可能 */
	@Execute(validator=false,roles="admin2")
	public String admin() {
		return "admin.jsp";
	}

	/** admin,guestロールのみ実行可能 **/
	@Execute(validator=false,roles="admin2,guest")
	public String guest() {
		return "guest.jsp";
	}
}
