package org.seasar.sastruts.example.form;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Required;

@Component(instance = InstanceType.SESSION)
public class ValidationMethodForm {
	@Required
	@IntegerType
	@Maxlength(maxlength=10)
	public String id;

	@Required
	public String name;

	/**
	 * 検証用メソッド
	 */
	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();
		//名前が「ホリバ」の場合はエラーとする
		if(name.equals("ホリバ")) {
			errors.add("name", new ActionMessage("名前がホリバとなっております!",false));
		}
		return errors;
	}

}
