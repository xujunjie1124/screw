package com.jd.ofc.screw.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.jd.ofc.screw.annotations.ScrewAlias;
import com.jd.ofc.screw.annotations.ScrewIgnore;
import com.jd.ofc.screw.annotations.ScrewIgnoreCase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ReflectUtils {

    private static final Map<Class<?>, Map<String, Method>> getterCache = new ConcurrentHashMap<Class<?>, Map<String, Method>>();
    private static final Map<Class<?>, Map<String, Method>> setterCache = new ConcurrentHashMap<Class<?>, Map<String, Method>>();
    private static final Map<Class<?>, Map<String, Field>> propertyCache = new ConcurrentHashMap<Class<?>, Map<String, Field>>();

    /**
     * 获取所有的setter方法
     * 
     * @param clazz
     * @return
     */
    public static Map<String, Method> getSetterMethods(Class<?> clazz) {
        Map<String, Method> ret = setterCache.get(clazz);
        if (ret != null) {
            return ret;
        }

        ret = new HashMap<String, Method>();
        Method[] methods = clazz.getMethods();

        boolean isScrewIgnoreCase = clazz.isAnnotationPresent(ScrewIgnoreCase.class);
        for (Method method : methods) {
            if (method.getName().length() < 4
                    || !method.getName().startsWith("set")
                    || Modifier.isStatic(method.getModifiers())
                    || Modifier.isAbstract(method.getModifiers())
                    || !method.getReturnType().equals(Void.TYPE)
                    || method.getParameterTypes().length != 1) {
                continue;
            }
            String propertyName = getPropertyName(method);
            // 设置别名
            Field field = getFields(clazz).get(propertyName);
            if (field != null) {
                if (field.isAnnotationPresent(ScrewIgnore.class)) {
                    continue;
                }
                String alias = getAlias(field);
                propertyName = alias != null ? alias : propertyName;
            }
            propertyName = isScrewIgnoreCase ? propertyName.toLowerCase() : propertyName;
            ret.put(propertyName, method);
        }
        setterCache.put(clazz, ret);
        return ret;
    }

    /**
     * 获取属性名
     * 
     * @param method
     * @return
     */
    public static String getPropertyName(Method method) {
        String methodName = method.getName();
        int index = (methodName.charAt(0) == 'i' ? 2 : 3);
        String propertyName = Character.toLowerCase(methodName.charAt(index))
                + methodName.substring(index + 1);
        return propertyName;
    }

    /**
     * 获取别名
     * 
     * @param field
     * @return
     */
    public static String getAlias(Field field) {
        if (field.isAnnotationPresent(ScrewAlias.class)) {
            ScrewAlias alias = field.getAnnotation(ScrewAlias.class);
            return alias.value();
        }
        if (field.isAnnotationPresent(XStreamAlias.class)) {
            XStreamAlias alias = field.getAnnotation(XStreamAlias.class);
            return alias.value();
        }
        return null;
    }

    public static Map<String, Field> getFields(Class<?> clazz) {
        Map<String, Field> ret = propertyCache.get(clazz);
        if (ret != null) {
            return ret;
        }

        boolean isScrewIgnoreCase = clazz.isAnnotationPresent(ScrewIgnoreCase.class);
        ret = new HashMap<String, Field>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            String propertyName = field.getName();
            propertyName = isScrewIgnoreCase ? propertyName.toLowerCase() : propertyName;
            ret.put(propertyName, field);
        }
        if (clazz.getSuperclass() != null) {
            Map<String, Field> superClassFields = getSuperClassFields(clazz);
            putAll(ret, superClassFields);
        }
        propertyCache.put(clazz, ret);
        return ret;
    }

    public static Map<String, Field> getSuperClassFields(Class<?> clazz) {
        Map<String, Field> ret = new HashMap<String, Field>();
        Field[] fields = clazz.getDeclaredFields();
        boolean isScrewIgnoreCase = clazz.isAnnotationPresent(ScrewIgnoreCase.class);
        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            String propertyName = field.getName();
            propertyName = isScrewIgnoreCase ? propertyName.toLowerCase() : propertyName;
            ret.put(propertyName, field);
        }
        if (clazz.getSuperclass() != null) {
            Map<String, Field> superClassFields = getSuperClassFields(clazz
                    .getSuperclass());
            putAll(ret, superClassFields);
        }
        return ret;
    }
    
    private static void putAll(Map<String, Field> map, Map<String, Field> subMap){
        for(Entry<String, Field> entry : subMap.entrySet()){
            if(!map.containsKey(entry.getKey())){
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
