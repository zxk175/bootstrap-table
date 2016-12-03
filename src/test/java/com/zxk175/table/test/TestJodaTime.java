package com.zxk175.table.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Created by zxk175 on 16/11/25.
 */
public class TestJodaTime {
    private static final Logger log = LogManager.getLogger(TestJodaTime.class);

    @Test
    public void test1() {
        // 取得当前时间
        DateTime dt = new DateTime();
        log.debug("当前时间：" + dt.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
