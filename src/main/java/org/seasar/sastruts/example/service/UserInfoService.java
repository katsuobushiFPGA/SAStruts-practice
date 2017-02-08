package org.seasar.sastruts.example.service;

import java.util.HashMap;
import java.util.Map;

import org.seasar.sastruts.example.entity.UserInfo;

public class UserInfoService {

	public UserInfo getUserInfo(String userName, String password) {
		UserInfo userInfo = new UserInfo();
		Map<String,String> trustMap = new HashMap<>();
		trustMap.put("admin", "admin");

		if(trustMap.containsKey(userName)) {
			if(trustMap.get(userName).equals(password)) {
				userInfo.id = userName;
				userInfo.password = password;
			}
		}
		return null;
	}

}
