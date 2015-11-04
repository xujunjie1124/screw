package com.wj2304.screw.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wj2304.screw.common.Assert;
import com.wj2304.screw.common.utils.StringUtils;
import com.wj2304.screw.exception.ScrewException;
import com.wj2304.screw.parser.ParserStateMachine;

/**
 * 使用Dom4j解析xml
 * 
 * @author 须俊杰
 */
public class Dom4jReader<T> implements Reader<T> {

    private static final Logger logger = LoggerFactory
            .getLogger(Dom4jReader.class);

    @SuppressWarnings("unchecked")
    @Override
    public T read(String xml, Class<T> clazz) throws Exception {
        logger.info("读取XML信息");
        if (StringUtils.isBlank(xml) || clazz == null) {
            throw new ScrewException("xml or clazz can not be null");
        }
        
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = reader.read(inputStream);
        if (document == null) {
            Assert.notNull(document);
        }

        return (T) ParserStateMachine
                .toObject(document.getRootElement(), clazz);
    }

}
