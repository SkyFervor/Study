package bean;

import common.Bean;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
		test1();
	}

	public static void test1() throws InvocationTargetException, IllegalAccessException {
		Bean bean = new Bean();
		bean.setValue(1);
		bean.setName("test");

		Bean newBean = new Bean();
		BeanUtils.copyProperties(newBean, bean);
		System.out.println(newBean);
	}

}
