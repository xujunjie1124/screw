package com.jd.ofc.screw.parser;

import java.lang.reflect.Array;
import java.util.List;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jd.ofc.screw.support.ArrayProxy;
import com.jd.ofc.screw.support.ArrayProxyFactoryUsingJavassist;

public class ArrayParser implements Parser {

    private static final Logger logger = LoggerFactory
            .getLogger(ArrayParser.class);

    public ArrayParser(Class<?> clazz) {
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        Class<?> componentType = clazz.getComponentType();
        List<Element> nodes = element.elements();
        Object ret = Array.newInstance(componentType, nodes.size());
        ArrayProxy arrayProxy = ArrayProxyFactoryUsingJavassist.INSTANCE.getArrayProxy(clazz);
        for (int i = 0; i < nodes.size(); i++) {
            Element e = nodes.get(i);
            logger.debug("Element name = " + e.getName()
                    + " , Element value = " + e.getText().trim());
            arrayProxy.set(ret, i, ParserStateMachine.toObject(e, componentType));
        }

        return ret;
    }
}
