package org.seasar.sastruts.example.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class RegisterSessionForm implements Serializable{
	public static final long serialVersionUID = 1L;
	public String message;
}
