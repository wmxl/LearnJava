package Testlog;

import org.apache.log4j.Logger;

public class TestLog4j {


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TestLog4j.class.getName());
        logger.info("i'm a log");
    }

}
