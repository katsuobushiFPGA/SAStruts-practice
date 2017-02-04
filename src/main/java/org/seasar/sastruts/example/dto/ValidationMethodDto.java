package org.seasar.sastruts.example.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Required;

@Component(instance = InstanceType.SESSION)
public class ValidationMethodDto implements Serializable{
	public static final long serialVersionUID = 1L;
	@Required
	@IntegerType
	@Maxlength(maxlength=10)
	public String id;
	@Required
	public String name;
}
