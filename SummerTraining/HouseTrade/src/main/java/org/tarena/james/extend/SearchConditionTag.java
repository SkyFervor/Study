package org.tarena.james.extend;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SearchConditionTag extends SimpleTagSupport{
	/**
	 * 判断是否包含数字
	 * @param params
	 * @return true 包含 false 不包含
	 */
	private boolean isContainsDigital(String params){
		boolean flag = false;
		for(int i=0;i<params.length();i++){
			char ch = params.charAt(i);
			if(ch>='0' && ch<='9'){
				flag = true;
			}
		}
		return flag;
	}
	
	private String getContainsSC(String params,List<SearchCondition> scList){
		String containsSC = null;
		for(int i=0;i<scList.size();i++){
			SearchCondition sc = scList.get(i);
			if(params.contains(sc.getScid())){
				containsSC = sc.getScid();
				break;
			}
		}
		return containsSC;
	}
	
	public void doTag() throws JspException, IOException {
		PageContext ctx = (PageContext) getJspContext();
		JspWriter out = ctx.getOut();
		HttpServletRequest req = (HttpServletRequest) ctx.getRequest();
		String contextPath = req.getContextPath();
		String params = (String) req.getAttribute("params");
		String place = (String)req.getAttribute("place");
		if(params == null || "".equals(params.trim())){
			List<SearchConditionGroup> scgList = 
				SearchConditionConfigLoader.load();
			for(int i=0;i<scgList.size();i++){
				SearchConditionGroup scg = scgList.get(i);
				String scgname = scg.getScgname();
				out.println("<dl class='selitem lh24'>");
				out.println("<dt>"+scgname+":</dt>");
				List<SearchCondition> scList = scg.getSearchConditions();
				out.println("<dd>");
				out.println("<a class='cur' href='"+contextPath+"/'><em>不限</em></a>");
				for(int j=0;j<scList.size();j++){
					SearchCondition sc = scList.get(j);
					out.println("<a href='"+contextPath+"/"+sc.getScid()+"/'><em>"+sc.getScname()+"</em></a>");
				}
				out.println("</dd>");
				out.println("</dl>");
			}
		}else{
			List<SearchConditionGroup> scgList = 
				SearchConditionConfigLoader.load();
			boolean flag = isContainsDigital(params);
			if(flag){//参数路径包含数字
				for(int i=0;i<scgList.size();i++){
					SearchConditionGroup scg = scgList.get(i);
					String containsSC = getContainsSC(params,scg.getSearchConditions());
					if(containsSC == null){//不在同一组
						String scgname = scg.getScgname();
						out.println("<dl class='selitem lh24'>");
						out.println("<dt>"+scgname+":</dt>");
						List<SearchCondition> scList = scg.getSearchConditions();
						out.println("<dd>");
						out.println("<a class='cur' href='"+contextPath+"/"+params+"/'><em>不限</em></a>");
						for(int j=0;j<scList.size();j++){
							SearchCondition sc = scList.get(j);
							out.println("<a href='"+contextPath+"/"+sc.getScid()+params+"/'><em>"+sc.getScname()+"</em></a>");
						}
						out.println("</dd>");
						out.println("</dl>");
					}else{
						String scgname = scg.getScgname();
						out.println("<dl class='selitem lh24'>");
						out.println("<dt>"+scgname+":</dt>");
						List<SearchCondition> scList = scg.getSearchConditions();
						out.println("<dd>");
						if(params.length() == containsSC.length()){
							out.println("<a href='"+contextPath+"/'><em>不限</em></a>");
						}else{
							out.println("<a href='"+contextPath+"/"+params.replace(containsSC,"")+"/'><em>不限</em></a>");
						}
						for(int j=0;j<scList.size();j++){
							SearchCondition sc = scList.get(j);
							if(params.contains(sc.getScid())){
								out.println("<a class='cur' href='"+contextPath+"/"+params.replace(containsSC, sc.getScid())+"/'><em>"+sc.getScname()+"</em></a>");
							}else{
								out.println("<a href='"+contextPath+"/"+params.replace(containsSC, sc.getScid())+"/'><em>"+sc.getScname()+"</em></a>");
							}
						}
						out.println("</dd>");
						out.println("</dl>");
					}
				}
			}else{//不包含数字
				
			}
		}
	}

}
