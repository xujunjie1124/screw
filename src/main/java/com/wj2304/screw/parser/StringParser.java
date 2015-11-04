package com.wj2304.screw.parser;

import org.dom4j.Element;

public class StringParser implements Parser {

    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        return element.getText();
    }
}
