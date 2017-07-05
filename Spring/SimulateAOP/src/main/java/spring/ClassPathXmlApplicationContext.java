package spring;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements ApplicationContext {
	private Map<String, Object> beans = new HashMap<String, Object>();

	public ClassPathXmlApplicationContext() throws JDOMException, IOException, ReflectiveOperationException {
		this("spring-beans.xml");
	}

	public ClassPathXmlApplicationContext(String configLocation)
			throws JDOMException, IOException, ReflectiveOperationException {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream(configLocation));
		// Document doc = sb.build("src/spring-beans.xml");
		Element root = doc.getRootElement();
		List<Element> list = root.getChildren("bean");
		for (Element element : list) {
			String id = element.getAttributeValue("name");
			String clazz = element.getAttributeValue("class");

			Object obj = Class.forName(clazz).newInstance();
			beans.put(id, obj);
		}

		for (Element element : list) {
			String id = element.getAttributeValue("name");
			Object obj = beans.get(id);
			Class<?> clazz = obj.getClass();

			for (Element property : element.getChildren("property")) {
				String name = property.getAttributeValue("name");
				String bean = property.getAttributeValue("bean");

				Field field = clazz.getDeclaredField(name);
				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				Method set_method = clazz.getMethod(methodName, field.getType());

				set_method.invoke(obj, beans.get(bean));
			}
		}
	}

	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}
}
