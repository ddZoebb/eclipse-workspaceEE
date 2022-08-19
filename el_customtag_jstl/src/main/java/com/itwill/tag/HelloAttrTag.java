package com.itwill.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloAttrTag extends TagSupport {
	private String name;

	public HelloAttrTag() {

		System.out.println("1.helloAttributeTag 기본생성자");
	}

	public void setName(String name) {
		System.out.println("2.HelloAttributeTag.setName(" + name + ")");
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		String msg = "";
		if (name.equals("차은우")) {
			msg = "잘생긴" + name + "님 안녕하세요.<br>";
		} else {
			msg = name + "님 안녕하세요.<br>";

		}
		try {
			pageContext.getOut().print(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
}
