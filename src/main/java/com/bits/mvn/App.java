package com.bits.mvn;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App{
    private static Logger logger = LogManager.getLogger(App.class);
    private String name = "Hello";
    
    public String greet(String name){
        return "hello " + name;
    }
    
    public static void main(String args[]){
        App app = new App();
        if(args.length >0){
            logger.info(app.greet(args[0]));
        }
    }
}
