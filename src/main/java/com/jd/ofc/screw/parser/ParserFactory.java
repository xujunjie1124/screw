package com.jd.ofc.screw.parser;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParserFactory {

    private static final Map<Class<?>, Parser> PARSER_MAP = new HashMap<Class<?>, Parser>();
    
    private static final Object LOCK = new Object();
    
    static {
        PARSER_MAP.put(int.class, new IntParser());
        PARSER_MAP.put(long.class, new LongParser());
        PARSER_MAP.put(short.class, new ShortParser());
        PARSER_MAP.put(float.class, new FloatParser());
        PARSER_MAP.put(double.class, new DoubleParser());
        PARSER_MAP.put(boolean.class, new BooleanParser());
//        PARSER_MAP.put(char.class, new CharacterParser());
//        
        PARSER_MAP.put(Integer.class, PARSER_MAP.get(int.class));
        PARSER_MAP.put(Long.class, PARSER_MAP.get(long.class));
        PARSER_MAP.put(Short.class, PARSER_MAP.get(short.class));
        PARSER_MAP.put(Float.class, PARSER_MAP.get(float.class));
        PARSER_MAP.put(Double.class, PARSER_MAP.get(double.class));
        PARSER_MAP.put(Boolean.class, PARSER_MAP.get(boolean.class));
//        PARSER_MAP.put(Character.class, PARSER_MAP.get(char.class));
        
        PARSER_MAP.put(BigDecimal.class, new BigDecimalParser());
//        PARSER_MAP.put(BigInteger.class, new BigIntegerParser());
//        
        PARSER_MAP.put(String.class, new StringParser());
//        
        PARSER_MAP.put(int[].class, new ArrayParser(int.class));
        PARSER_MAP.put(long[].class, new ArrayParser(long.class));
        PARSER_MAP.put(short[].class, new ArrayParser(short.class));
        PARSER_MAP.put(float[].class, new ArrayParser(float.class));
        PARSER_MAP.put(double[].class, new ArrayParser(double.class));
        PARSER_MAP.put(boolean[].class, new ArrayParser(boolean.class));
//        PARSER_MAP.put(byte[].class, new ByteArrayParser());
//        PARSER_MAP.put(char[].class, new CharArrayParser());
//        
        PARSER_MAP.put(Integer[].class, new ArrayParser(Integer.class));
        PARSER_MAP.put(Long[].class, new ArrayParser(Long.class));
        PARSER_MAP.put(Short[].class, new ArrayParser(Short.class));
        PARSER_MAP.put(Float[].class, new ArrayParser(Float.class));
        PARSER_MAP.put(Double[].class, new ArrayParser(Double.class));
        PARSER_MAP.put(Boolean[].class, new ArrayParser(Boolean.class));
        
        PARSER_MAP.put(String[].class, new ArrayParser(String.class));
    }
    
    public static Parser getParser(Class<?> clazz) {
        Parser ret = PARSER_MAP.get(clazz);
        if(ret == null) {
            synchronized(LOCK) {
                ret = PARSER_MAP.get(clazz);
                if(ret == null) {
                    if (clazz.isEnum()) {
//                        ret = new EnumParser(clazz);
                        PARSER_MAP.put(clazz, ret);
                    } else if (Collection.class.isAssignableFrom(clazz)) {
//                        ret = new CollectionParser();
//                        PARSER_MAP.put(clazz, ret);
                    } else if (Map.class.isAssignableFrom(clazz)){
                        
                    } else if (clazz.isArray()) {
                        Class<?> elementClass = clazz.getComponentType();
                        ret = new ArrayParser(elementClass);
                        PARSER_MAP.put(clazz, ret);
                    } else {
                        ret = new ObjectParser();
                        ((ObjectParser)ret).init(clazz);
                        PARSER_MAP.put(clazz, ret);
                    }
                }
            }
        }
        return ret;
    }
}
