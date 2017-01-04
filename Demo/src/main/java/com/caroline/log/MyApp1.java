package com.caroline.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Caroline.Han
 * Date: 2017-01-04
 * Time: 下午5:27
 */
public class MyApp1 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MyApp1.class.getName());
        logger.info("before");
        Foo.doIt();
        logger.info("after");

        try {
            int i = 10 / 0;
        }catch (Exception e) {
            logger.error("errorTest", e);
        }
    }
}
