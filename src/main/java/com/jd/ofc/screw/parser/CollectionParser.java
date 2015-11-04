package com.jd.ofc.screw.parser;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.dom4j.Element;

public class CollectionParser extends ComplexParser {

    private Type elementType;

    public CollectionParser(Type elementType) {
        this.elementType = elementType;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        Class<?> clazzImpl = getImplClass(clazz);

        Collection obj = null;
        try {
            obj = (Collection) clazzImpl.newInstance();

            Class<?> eleClass = (Class<?>) elementType;
            List<Element> nodes = element.elements();
            for (int i = 0; i < nodes.size(); i++) {
                Element e = nodes.get(i);
                obj.add(ParserStateMachine.toObject(e, eleClass));
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return obj;
    }
}
