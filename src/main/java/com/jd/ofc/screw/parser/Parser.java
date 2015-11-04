package com.jd.ofc.screw.parser;

import org.dom4j.Element;


public interface Parser {
    Object convertTo(Element element, Class<?> clazz) throws Exception;
}
