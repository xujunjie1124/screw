package com.jd.ofc.screw.support;

import java.lang.reflect.Method;

import org.dom4j.Element;

import com.jd.ofc.screw.parser.Parser;

public class PropertyHolder {

    private String name;
    private Class<?> type;
    private Method method;
    private Parser parser;
    
    public void invoke(Element element, Object obj) {
        try {
            method.invoke(obj, parser.convertTo(element, type));
        } catch (Throwable e) {
            e.printStackTrace();
        } 
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Class<?> getType() {
        return type;
    }
    public void setType(Class<?> type) {
        this.type = type;
    }
    public Parser getParser() {
        return parser;
    }
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
    
}
