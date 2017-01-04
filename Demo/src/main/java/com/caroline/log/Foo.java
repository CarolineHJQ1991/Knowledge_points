package com.caroline.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Caroline.Han
 * Date: 2017-01-04
 * Time: 下午5:26
 */
public class Foo {
    public static void doIt() {
        Logger logger = LoggerFactory.getLogger(Foo.class.getName());
        logger.debug("let's do it!");
    }
}
