package com.jd.ofc.screw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jd.ofc.screw.common.Assert;
import com.jd.ofc.screw.exception.ScrewException;
import com.jd.ofc.screw.reader.Dom4jReader;
import com.jd.ofc.screw.reader.Reader;

public abstract class Screw {

    private static final Logger logger = LoggerFactory.getLogger(Screw.class);

    /**
     * 将XML字符串转换成指定类型的对象
     * 
     * @param xml 待解析的XML字符串
     * @param clazz 对象类型
     * @return 指定类型对象的实例
     */
    public static <T> T fromXML(String xml, Class<T> clazz) {
        Assert.notNull(xml, "XML不能为空");
        Assert.notNull(clazz, "Class对象不能为空");
        long start = System.currentTimeMillis();

        T ret = null;
        try {
            Reader<T> reader = new Dom4jReader<T>();;
            ret = (T) reader.read(xml, clazz);

            logger.info("XML解析完毕,耗时:" + (System.currentTimeMillis() - start)
                    + "ms");
            return ret;
        } catch (Throwable t) {
            logger.error("XML解析异常 : Class = " + clazz.getName(), t);
            throw new ScrewException();
        }
    }
}
