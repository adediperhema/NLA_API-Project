package com.etz.NLA_Fast_Credit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;


public class NLAConfig {
	

    private static final Logger log;

    static {
        log = Logger.getLogger(NLAConfig.class.getName());
    }

    public static String getValue(final String key) {
        final Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(new File("cfg\\NLA.properties"));
            //input = new FileInputStream(new File("D:\\vasgate\\cfg\\NLA.properties"));
            //props.load(new FileReader(new File("D:\\vasGate\\cfg\\accraheartsoak.properties")));

            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException ex) {
            System.out.println("Exception:: " + ex.getMessage());
            NLAConfig.log.info((String) ("System.out.println(\"Exception:: \" + ex.getMessage());->PROCESS EXCEPTION=>" + ex.getMessage()));
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Exception:: " + e.getMessage());
                    NLAConfig.log.info((String) ("System.out.println(\"Exception:: \" + ex.getMessage());->CONFIG EXCEPTION=>" + e.getMessage()));

                }
            }
        }
    }


}
