package tn.com.abt.utils;

import org.apache.commons.lang.StringUtils;
import org.jboss.logging.Logger.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * 
 * @author AMMAR.MAHER
 *
 */
public class CommonLogger {

	static Logger logger = LoggerFactory.getLogger(CommonLogger.class);

	public static String getMessage(HttpStatus httpResponse, Long idAccessClient, String className, String methodName, String message,
			String... params) {

		String paramsValue = StringUtils.EMPTY;
		for (String param : params) {
			paramsValue = (!paramsValue.isEmpty()) ? paramsValue + ", " + param : param;
		}

		return "- IdAccessClient [" + idAccessClient + "]" + " - HttpResponse [" + httpResponse.value() + ", " + httpResponse.name()
				+ "] - Class [" + className + "] - Method [" + methodName + "] - Params [" + paramsValue + "]" + " - Message [" + message
				+ "]";

	}

	public static void logger(Level level, HttpStatus httpResponse, Long idAccessClient, String className, String methodName,

			String message, Exception exception, String... params) {

		String logMessage = CommonLogger.getMessage(httpResponse, idAccessClient, className, methodName, message, params);

		switch (level) {
		case TRACE:
			logger.trace(logMessage, exception);
			break;
		case DEBUG:
			logger.debug(logMessage, exception);
			break;
		case INFO:
			logger.info(logMessage, exception);
			break;
		case WARN:
			logger.warn(logMessage, exception);
			break;
		case ERROR:
			logger.error(logMessage, exception);
			break;
		default:
			break;

		}
	}
}
