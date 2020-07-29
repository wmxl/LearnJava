package Testlog;

import java.io.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class TestLogger {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(TestLogger.class.getName());
//        logger.info("i'm a log");
        LogManager logManager = LogManager.getLogManager();
        InputStream inputStream=null;
        inputStream = TestLogger.class.getClassLoader().getResourceAsStream("D:\\IDEACodes\\LearnJava\\src\\Testlog\\log.properties");
        try {
            logManager.readConfiguration(inputStream);
        } catch (SecurityException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        logManager.addLogger(logger);
        logger.info("i'm a log");
    }
}