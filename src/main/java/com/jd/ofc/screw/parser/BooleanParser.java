package com.jd.ofc.screw.parser;

import org.dom4j.Element;

public class BooleanParser implements Parser {

	@Override
	public Object convertTo(Element element, Class<?> clazz) {
        return Boolean.valueOf(element.getTextTrim());
	}

}
