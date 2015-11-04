package com.wj2304.screw.support;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import com.wj2304.screw.common.utils.StringUtils;

/**
 * 动态生成Array代理类，来替代Array里面的某些方法，来提高性能
 *
 * @author 须俊杰
 */
public class ArrayProxyFactoryUsingJavassist {

    private static final Map<Class<?>, ArrayProxy> arrayCache = new ConcurrentHashMap<Class<?>, ArrayProxy>();
    public static final ArrayProxyFactoryUsingJavassist INSTANCE = new ArrayProxyFactoryUsingJavassist();
    
    protected static final HashMap<Class<?>, String> primitiveWrapMap = new HashMap<Class<?>, String>();
    
    static {
        primitiveWrapMap.put(short.class, Short.class.getCanonicalName());
        primitiveWrapMap.put(byte.class, Byte.class.getCanonicalName());
        primitiveWrapMap.put(int.class, Integer.class.getCanonicalName());
        primitiveWrapMap.put(char.class, Character.class.getCanonicalName());
        primitiveWrapMap.put(float.class, Float.class.getCanonicalName());
        primitiveWrapMap.put(double.class, Double.class.getCanonicalName());
        primitiveWrapMap.put(long.class, Long.class.getCanonicalName());
        primitiveWrapMap.put(boolean.class, Boolean.class.getCanonicalName());
    }
    
    private ArrayProxyFactoryUsingJavassist() {
        
    }
    
    public ArrayProxy getArrayProxy(Class<?> clazz) throws Exception {
        if(!clazz.isArray())
            throw new IllegalArgumentException("type error, it's not array");
            
        ArrayProxy ret = arrayCache.get(clazz);
        if(ret != null)
            return ret;
        
        synchronized(arrayCache) {
            ret = arrayCache.get(clazz);
            if(ret != null)
                return ret;
            
            ret = _getArrayProxy(clazz);
            arrayCache.put(clazz, ret);
            return ret;
        }
    }
    
    @SuppressWarnings("unchecked")
    private ArrayProxy _getArrayProxy(Class<?> clazz) throws Exception {
//      long start = System.currentTimeMillis();
        ClassPool classPool = ClassPool.getDefault();
        classPool.insertClassPath(new ClassClassPath(ArrayProxy.class));
        
        CtClass cc = classPool.makeClass("com.wj2304.screw.common.ArrayField" + UUID.randomUUID().toString().replace("-", ""));
        cc.addInterface(classPool.get(ArrayProxy.class.getName()));
        
        cc.addMethod(CtMethod.make(createArraySetCode(clazz), cc));
        
        ArrayProxy ret = (ArrayProxy) cc.toClass().getConstructor().newInstance();
//      long end = System.currentTimeMillis();
//      System.out.println("Javassist generates class proxy time -> " + (end - start));
        return ret;
    }
    
    /**
     * set方法用来替代Array.set方法
     * @param clazz
     * @return
     */
    private String createArraySetCode(Class<?> clazz) {
        StringBuilder code = new StringBuilder();
        code.append("public void set(Object array, int index, Object value){\n")
            .append(StringUtils.replace("\t(({})array)[index] = ", clazz.getCanonicalName()));
        
        Class<?> componentType = clazz.getComponentType();
        if(componentType.isPrimitive()) {
            code.append(StringUtils.replace("(({})value).{}Value()", primitiveWrapMap.get(componentType), componentType.getCanonicalName()));
        } else {
            code.append(StringUtils.replace("({})value", componentType.getCanonicalName()));
        }
        
        code.append(";\n")
            .append("}");
        return code.toString();
    }
}
