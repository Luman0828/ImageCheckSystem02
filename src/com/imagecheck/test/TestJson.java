package com.imagecheck.test;

import java.util.HashMap;
import java.util.Map;

import com.imagecheck.pojo.User;

import net.sf.json.JSONObject;

public class TestJson {
	public static void main(String[] args) {
		Map map=new HashMap();
		User user=new User("dfsdf","aa", "dddd", 0);
		map.put("smg", "dfe");
		map.put("user", user);
		
		System.out.println(JSONObject.fromObject(map).toString());
	}
}
