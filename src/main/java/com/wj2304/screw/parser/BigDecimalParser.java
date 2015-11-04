package com.wj2304.screw.parser;

import java.math.BigDecimal;

import org.dom4j.Element;

public class BigDecimalParser implements Parser{

    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        return new BigDecimal(element.getTextTrim());
    }

}
