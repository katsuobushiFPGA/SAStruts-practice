/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.sastruts.example.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.seasar.framework.aop.annotation.Trace;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Required;

public class IndexAction {

	@Required
	@IntegerType
	public String arg0;

	@Required
	@IntegerType
	public String arg1;

	@IntegerType
	public Integer ans;

	public String message;
	public List<String> listMsg;
	public Map<String,String> mapMsg;

	public List<String> searchResult;

	@Trace
    @Execute(validator = false)
	public String index() {
		/* インスタンス生成 */
		this.mapMsg = new HashMap<>();
		this.listMsg = new ArrayList<>();
		this.searchResult = new ArrayList<>();

		this.mapMsg.put("key", "こんばんは！");
		this.listMsg.add("こんにちは");
		this.message = "Hello SAStruts!";
		this.searchResult.add("S2Struts");
		this.searchResult.add("Struts");
		this.searchResult.add("S2 Doma");
		this.searchResult.add("S2JDBC");

        return "index.jsp";
	}
	@Trace
    @Execute(input="index.jsp")
	public String calc() {
		ans = new Integer(arg0) + new Integer(arg1);
		return "index.jsp";
	}

}
