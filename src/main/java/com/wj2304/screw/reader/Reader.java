package com.wj2304.screw.reader;

/**
 * XML读取器
 * 
 * @author 须俊杰
 */
public interface Reader<T> {

    /**
     * 解析xml字符串，然后生成clazz类型的对象并返回
     * 
     * @param xml 待解析的xml字符串
     * @param clazz 待生成的对象类型
     * @return 返回有xml解析后的对象
     * @throws Exception
     */
    public abstract T read(String xml, Class<T> clazz) throws Exception;
}
