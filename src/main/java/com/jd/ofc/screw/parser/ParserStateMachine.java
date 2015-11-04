package com.jd.ofc.screw.parser;

import org.dom4j.Element;


public class ParserStateMachine {
    
    @SuppressWarnings("unchecked")
    public static <T> T toObject(Element element, Class<?> clazz) throws Exception {
        Parser parser = ParserFactory.getParser(clazz);
        return (T) parser.convertTo(element, clazz);
    }
}
