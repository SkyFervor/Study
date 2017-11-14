package controller;

import common.base.AbstractTest;
import common.controller.TestController;
import org.junit.Test;

import javax.annotation.Resource;

public class TestControllerTest extends AbstractTest {

	@Resource
	private TestController testController;

	@Test
	public void test1() throws Exception {
		testController.test();
	}

}