package org.seasar.sastruts.example.form;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class RegisterSessionForm {
	public String message;
}
