package com.silly.ecommerce.common.logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeLog {

    public static void info(String methodName, String message, Object... arguments) {
        if (arguments.length > 0) {
            log.info(getMessageTemplate(methodName, message), arguments);
        } else {
            log.info(getMessageTemplate(methodName, message));
        }
    }

    public static void debug(String methodName, String message, Object... arguments) {
        if (arguments.length > 0) {
            log.debug(getMessageTemplate(methodName, message), arguments);
        } else {
            log.debug(getMessageTemplate(methodName, message));
        }
    }

    public static void warn(String methodName, String message, Object... arguments) {
        if (arguments.length > 0) {
            log.warn(getMessageTemplate(methodName, message), arguments);
        } else {
            log.warn(getMessageTemplate(methodName, message));
        }
    }

    public static void error(String methodName, String message, Object... arguments) {
        if (arguments.length > 0) {
            log.error(getMessageTemplate(methodName, message), arguments);
        } else {
            log.error(getMessageTemplate(methodName, message));
        }
    }

    public static void trace(String methodName, String message, Object... arguments) {
        if (arguments.length > 0) {
            log.trace(getMessageTemplate(methodName, message), arguments);
        } else {
            log.trace(getMessageTemplate(methodName, message));
        }
    }

    private static String getMessageTemplate(String methodName, String message) {
        return "[" + methodName + "] " + message;
    }


}
