package com.jd.ofc.screw.parser;

import org.dom4j.Element;

import com.jd.ofc.screw.common.utils.SafeSimpleDateFormat;

public class DateParser implements Parser {

    private String datePattern;

    public DateParser() {
        this(null);
    }

    public DateParser(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        return SafeSimpleDateFormat.parse(element.getTextTrim(), this.datePattern);
    }

}
