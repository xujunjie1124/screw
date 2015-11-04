package com.wj2304.screw.parser;

import org.dom4j.Element;

public class IntParser implements Parser{

    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        return Integer.valueOf(element.getTextTrim());
    }
}
