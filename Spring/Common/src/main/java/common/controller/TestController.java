package common.controller;

import common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	public void test() {
		System.out.println(testService.test());
	}
}
