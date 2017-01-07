package com.caroline.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Caroline.Han
 * Date: 2017-01-05
 * Time: 上午11:37
 */

/**
 *  OFF、
    FATAL、
    ERROR、
    WARN、
    INFO、
    DEBUG、
    ALL
 */
public class LogbackDemo {
    private static Logger logger = LoggerFactory.getLogger(LogbackDemo.class.getName());
    public static void main(String[] args) {
        logger.trace("=======trace");
        logger.debug("=======debug");
        logger.info("=======info");
        logger.warn("=======warn");
        logger.error("=======error");
    }
}
