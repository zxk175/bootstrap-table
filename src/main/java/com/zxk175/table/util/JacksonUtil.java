package com.zxk175.table.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * 来源: https://www.oschina.net/code/snippet_2361282_53222
 */
public class JacksonUtil {
    private static JacksonUtil ju;
    private static JsonFactory jf;
    private static ObjectMapper mapper;

    private JacksonUtil() {
    }

    /**
     * 单例初始化
     *
     * @param @return
     * @return JacksonUtil
     * @throws
     * @Title: newInstance
     * @Description: TODO
     */
    public static JacksonUtil newInstance() {
        if (ju == null) ju = new JacksonUtil();
        return ju;
    }

    public static ObjectMapper getMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            //配置jackson不检查json串跟java实体类字段的一一对应
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //禁止使用int代表Enum的order()來反序列化Enum,非常危險
            mapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
        }
        return mapper;
    }

    public static JsonFactory getFactory() {
        if (jf == null) jf = new JsonFactory();
        return jf;
    }


    /**
     * @param @param  obj ： java对象
     * @param @return
     * @return String
     * @throws
     * @Title: obj2json
     * @Description: 把java对象转为json字符串
     */
    public String obj2json(Object obj) {
        if (null != obj) {
            JsonGenerator jg = null;
            try {
                jf = getFactory();
                mapper = getMapper();
                StringWriter out = new StringWriter();
                jg = jf.createJsonGenerator(out);
                mapper.writeValue(jg, obj);
                return out.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (jg != null) jg.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param @param  json ： json字符串换
     * @param @param  clz ： java对象class
     * @param @return
     * @return Object
     * @throws
     * @Title: json2obj
     * @Description: json字符串转换为java对象
     */
    public <E> E json2obj(String json, Class<E> clz) {
        if (null != json && !"".equals(json.trim())) {
            try {
                mapper = getMapper();
                return mapper.readValue(json, clz);
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
