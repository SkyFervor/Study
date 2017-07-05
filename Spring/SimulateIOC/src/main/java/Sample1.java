import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Sample1 {
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb
				.build(Sample1.class.getClassLoader().getResourceAsStream("test.xml"));
		Element root = doc.getRootElement();
		List<Element> list = root.getChildren("disk");

		for (int i = 0; i < list.size(); i++) {
			Element element = list.get(i);
			String name = element.getAttributeValue("name");
			String capacity = element.getChildText("capacity");
			String directories = element.getChildText("directories");
			String files = element.getChildText("files");
			System.out.println("磁盘信息：");
			System.out.println("分区盘符：" + name);
			System.out.println("分区容量：" + capacity);
			System.out.println("目录数：" + directories);
			System.out.println("文件数：" + files);
			System.out.println("----------------------------------");
		}
	}
}
