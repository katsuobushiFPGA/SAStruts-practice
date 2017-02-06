package org.seasar.sastruts.example.form;

import org.seasar.sastruts.example.annotation.RequiredArray;

public class MyListForm {
	@RequiredArray
	public String[] products;
}
