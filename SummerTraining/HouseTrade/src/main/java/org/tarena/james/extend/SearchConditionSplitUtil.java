package org.tarena.james.extend;

import java.util.ArrayList;
import java.util.List;

public class SearchConditionSplitUtil {
	public static List<String> split(String condParams){
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
}
