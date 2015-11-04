package com.wj2304.screw.parser;

import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wj2304.screw.annotations.ScrewIgnoreCase;
import com.wj2304.screw.common.Assert;
import com.wj2304.screw.compiler.DecodeCompiler;
import com.wj2304.screw.support.PropertyHolder;

public class ObjectParser implements Parser {

    private static final Logger logger = LoggerFactory
            .getLogger(ObjectParser.class);

    private Map<String, PropertyHolder> propertyHolderMap;

    /**
     * 初始化对象
     * <p>
     * 将对象的类型进行预编译，为每个属性指定解析器
     * 
     * @param clazz
     *            待解析的对象类型
     */
    public void init(Class<?> clazz) {
        propertyHolderMap = DecodeCompiler.compile(clazz);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object convertTo(Element element, Class<?> clazz) throws Exception {
        logger.debug(element.getName());
        if (clazz == null) {
            Assert.notNull(clazz);
        }

        boolean isScrewIgnoreCase = clazz.isAnnotationPresent(ScrewIgnoreCase.class);
        Object obj = clazz.newInstance();
        List<Element> childNodesList = element.elements();
        for (Element e : childNodesList) {
            logger.debug("Object = " + obj.getClass().getSimpleName()
                    + " , Element name = " + e.getName()
                    + " , Element value = " + e.getText().trim());
            
            String elementName = isScrewIgnoreCase ? e.getName().toLowerCase() : e.getName();
            PropertyHolder holder = propertyHolderMap.get(elementName);
            if (holder != null) {
                holder.invoke(e, obj);
            }

        }
        return obj;
    }

}
