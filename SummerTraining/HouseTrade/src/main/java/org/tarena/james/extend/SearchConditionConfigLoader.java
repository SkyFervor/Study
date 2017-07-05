package org.tarena.james.extend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class SearchConditionConfigLoader {
	public static final String DEFAULT_CONFIG = "search-condition.xml";
	private static List<SearchConditionGroup> scgList = 
		new ArrayList<SearchConditionGroup>();
	private static Map<String,SearchCondition> scMap = 
		new HashMap<String, SearchCondition>();
	static{
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(SearchConditionConfigLoader.class.
					getClassLoader().
					getResourceAsStream(DEFAULT_CONFIG));
			Element rootEle = doc.getRootElement();
			List<Element> scgEles = rootEle.elements();
			for(int i=0;i<scgEles.size();i++){
				SearchConditionGroup scg = new SearchConditionGroup();
				scgList.add(scg);
				Element scgEle = scgEles.get(i);
				scg.setScgname(scgEle.attributeValue("scgname"));
				List<Element> scEles = scgEle.elements();
				for(int j=0;j<scEles.size();j++){
					SearchCondition sc = new SearchCondition();
					scg.getSearchConditions().add(sc);
					Element scEle = scEles.get(j);
					sc.setScname(scEle.elementText("scname"));
					sc.setScid(scEle.elementText("scid"));
					sc.setScsql(scEle.elementText("scsql"));
					scMap.put(sc.getScid(), sc);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	public static List<SearchConditionGroup> load(){
		return scgList;
	}
	
	private static List<String> split(String condParams){
		List<Integer> positions = 
			new ArrayList<Integer>();
		List<String> condIds = 
			new ArrayList<String>();
		for(int i=0;i<condParams.length();i++){
			char ch = condParams.charAt(i);
			if(ch >= 'a' && ch <= 'z'){
				positions.add(i);
			}
		}
		for(int i=0;i<positions.size();i++){
			int position = positions.get(i);
			if(i == positions.size()-1){
				condIds.add( condParams.substring(position) );
			}else{
				condIds.add( condParams.substring(position, positions.get(i+1)) );
			}
		}
		return condIds;
	}
	
	public static String getParamsSQl(String params){
		List<String> scidList = split(params);
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<scidList.size();i++){
			String scid = scidList.get( i );
			SearchCondition sc = scMap.get(scid);
			String scsql = sc.getScsql();
			builder.append(scsql+" and ");
		}
		builder.append("1 = 1");
		String where = builder.toString();
		return where;
	}
	
//	public static void main(String[] args) {
//		List<SearchConditionGroup> scgs = load();
//		System.out.println(  );
//	}
}
