package common.controller;

import common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class TestController {

	private String s;

	@Autowired
	private TestService testService;

	public void test() {
		System.out.println(testService.test());
		System.out.println(s);
	}

	public void setS(String s) {
		this.s = s;
	}
}
