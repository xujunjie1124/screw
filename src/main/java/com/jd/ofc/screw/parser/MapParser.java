package com.jd.ofc.screw.parser;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

public class MapParser extends ComplexParser{

    private Type elementType;
    
    public MapParser(Type elementType) {
        this.elementType = elementType;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        
        Class<?> clazzImpl = getImplClass(clazz);
        Map obj = null;
        try {
            obj = (Map)clazzImpl.newInstance();
            
            Class<?> eleClass = (Class<?>) elementType;
            List<Element> nodes = element.elements();
            for (int i = 0; i < nodes.size(); i++) {
                Element e = nodes.get(i);
                List<Element> entry = e.elements();
                Element key = entry.get(0);
                Element value = entry.get(1);
                
                obj.put(key.getText(), ParserStateMachine.toObject(value, eleClass));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
        return obj;
    }

}
