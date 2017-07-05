package spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements ApplicationContext {
	private Map<String, Object> beans = new HashMap<String, Object>();

	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getClassLoader()
				.getResourceAsStream("spring-beans.xml")); // Document doc = sb.build("src/spring-beans.xml");
		Element root = doc.getRootElement();
		List<Element> list = root.getChildren("bean");
		for (Element element : list) {
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");

			Object obj = Class.forName(clazz).newInstance();
			beans.put(id, obj);
		}

		for (Element element : list) {
			String id = element.getAttributeValue("id");
			Object obj = beans.get(id);

			for (Element property : element.getChildren("property")) {
				String name = property.getAttributeValue("name");
				String bean = property.getAttributeValue("bean");

				String methodName = "set" + name.substring(0, 1).toUpperCase()
						+ name.substring(1);
				Object beanObj = beans.get(bean);
				Method m = obj.getClass().getMethod(methodName,
						beanObj.getClass().getInterfaces()[0]);

				m.invoke(obj, beanObj);
			}
		}
	}

	public Object getBean(String name) {
		return beans.get(name);
	}
}
