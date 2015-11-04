package com.jd.ofc.screw.parser;

import org.dom4j.Element;

public class ShortParser implements Parser{

    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        return Short.valueOf(element.getTextTrim());
    }

}
