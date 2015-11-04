package com.jd.ofc.screw.compiler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jd.ofc.screw.annotations.ScrewAlias;
import com.jd.ofc.screw.annotations.ScrewDatePattern;
import com.jd.ofc.screw.annotations.ScrewIgnoreCase;
import com.jd.ofc.screw.common.utils.ReflectUtils;
import com.jd.ofc.screw.exception.ScrewException;
import com.jd.ofc.screw.parser.CollectionParser;
import com.jd.ofc.screw.parser.ComplexParser;
import com.jd.ofc.screw.parser.DateParser;
import com.jd.ofc.screw.parser.MapParser;
import com.jd.ofc.screw.parser.ParserFactory;
import com.jd.ofc.screw.support.PropertyHolder;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class DecodeCompiler {

    private static final Logger logger = LoggerFactory
            .getLogger(DecodeCompiler.class);

    /**
     * 分析对象，为每一个属性指定解析器
     * 
     * @param clazz
     * @return
     */
    public static Map<String, PropertyHolder> compile(Class<?> clazz) {
        Map<String, PropertyHolder> propertyHolderMap = new HashMap<String, PropertyHolder>();

        boolean isScrewIgnoreCase = clazz.isAnnotationPresent(ScrewIgnoreCase.class);
        Map<String, Method> methods = ReflectUtils.getSetterMethods(clazz);
        Map<String, Field> fields = ReflectUtils.getFields(clazz);
        for (Entry<String, Method> entry : methods.entrySet()) {
            Method method = entry.getValue();

            String methodName = method.getName();
            String propertyName = Character.toLowerCase(methodName.charAt(3))
                    + methodName.substring(4);
            
            Field field = fields.get(isScrewIgnoreCase ? propertyName.toLowerCase() : propertyName);
            if (field == null) {
                logger.warn("根据Method生成的fieldname没有找到对应的File对象 : {} ",
                      propertyName);
                continue;
            } else if(field.isAnnotationPresent(ScrewAlias.class) 
                    || field.isAnnotationPresent(XStreamAlias.class)){
                propertyName = ReflectUtils.getAlias(field);
            }

            PropertyHolder propertyHolder = new PropertyHolder();
            propertyHolder.setName(propertyName);
            propertyHolder.setMethod(method);
            Class<?> type = method.getParameterTypes()[0];
            if (Collection.class.isAssignableFrom(type)) {
                // 处理Collection类型
                Type[] types = method.getGenericParameterTypes();
                if (types.length != 1
                        || !(types[0] instanceof ParameterizedType)) {
                    throw new ScrewException("not support the " + method);
                }

                ParameterizedType paramType = (ParameterizedType) types[0];
                Type[] types2 = paramType.getActualTypeArguments();
                if (types2.length != 1) {
                    throw new ScrewException("not support the " + method);
                }

                Type elementType = types2[0];
                propertyHolder.setType(CollectionParser.getImplClass(type));
                propertyHolder.setParser(new CollectionParser(elementType));
            } else if (Map.class.isAssignableFrom(type)) {
                // 处理Map类型
                Type[] types = method.getGenericParameterTypes();
                if (types.length != 1
                        || !(types[0] instanceof ParameterizedType)) {
                    throw new ScrewException("not support the " + method);
                }

                ParameterizedType paramType = (ParameterizedType) types[0];
                Type[] types2 = paramType.getActualTypeArguments();
                if (types2.length != 2) {
                    throw new ScrewException("not support the " + method);
                }

                // key暂时只支持String类型
                Type key = types2[0];
                if (!((key instanceof Class) && key == String.class)) {
                    throw new ScrewException("not support the " + method);
                }

                Type elementType = types2[1];
                propertyHolder.setType(ComplexParser.getImplClass(type));
                propertyHolder.setParser(new MapParser(elementType));
            } else if(Date.class.isAssignableFrom(type)){
                if(field.isAnnotationPresent(ScrewDatePattern.class)){
                    ScrewDatePattern datePattern = field.getAnnotation(ScrewDatePattern.class);
                    propertyHolder.setParser(new DateParser(datePattern.value()));
                } else {
                    propertyHolder.setParser(new DateParser());
                }
            } else {
                propertyHolder.setType(type);
                propertyHolder.setParser(ParserFactory.getParser(type));
            }
            String k = entry.getKey();
            k = isScrewIgnoreCase ? k.toLowerCase() : k;
            propertyHolderMap.put(k, propertyHolder);
        }

        return propertyHolderMap;
    }
}
