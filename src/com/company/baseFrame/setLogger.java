package com.company.baseFrame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;

public class setLogger {

  static {

    Properties props = new Properties();
    String loggerProp = PropertyManager.getString("logger.prop", "D:\\workspace\\AutomationTest\\src\\com\\company\\testUtil\\log4j.properties");
    try {
      InputStream is = new FileInputStream(loggerProp);
      props.load(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    PropertyConfigurator.configure(props);

  }

  Logger logger = null;

  public static setLogger getLogger(Class<?> T) {

    setLogger dd = new setLogger();
    dd.logger = Logger.getLogger(T);
    return dd;
  }

  //overwritten
  public void log(String msg) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar ca = Calendar.getInstance();
    logger.info(msg);
    logger.getName();
    Reporter.log("Reporter:" + sdf.format(ca.getTime()) + "===>" + msg);
  }

  public void debug(String msg) {
    logger.debug(msg);
  }

  public void warn(String msg) {
    logger.warn(msg);
    Reporter.log("<div style='background-color:yellow'>Reporter:" + this.getLoggerName() + " ||===|| " + msg + "</div>");
  }

  public void warn(String msg, Exception e) {
    logger.warn(msg, e);
    Reporter.log("Reporter:" + msg);
  }

  public void pass(String msg) {
    logger.info(msg);
    Reporter.log("Pass<" + this.getLoggerName() + ">" + msg);
  }

  public void error(String msg) {
    logger.error(msg);
    Reporter.log("Error<" + this.getLoggerName() + ">" + msg);
  }

  public void error(String message, Exception e, WebDriver d) {
    e.printStackTrace();
    logger.error(e);
    logger.error(e.getCause());
    ScreenShot.screenShotError(d, message);
  }

  public String getLoggerName() {
    try {
      Field f = logger.getClass().getSuperclass().getDeclaredField("name");
      f.setAccessible(true);
      return (String) f.get(logger);
    } catch (Exception e) {
      e.printStackTrace();
      return "errorLogger";
    }
  }
  
  public void info(String msg) {
	    logger.info(msg);
	    Reporter.log("Info<" + this.getLoggerName() + ">" + msg);
	  }
}
