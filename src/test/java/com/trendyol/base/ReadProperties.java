package com.trendyol.base;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

class ReadProperties {

    private static Properties envProperties;
    private static final Logger logger = Logger.getLogger(ReadProperties.class);

    static {
        envProperties = new Properties();
        try {
            InputStream propertiesStream = BaseTest.class.getClassLoader().getResourceAsStream(BaseTest.environment +".properties");
            envProperties.load(propertiesStream);
            propertiesStream.close();
            Set<Map.Entry<Object, Object>> entrySet = envProperties.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            propertiesStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String baseUrl() {
        String baseUrl = envProperties.getProperty("baseUrl");
        logger.info("baseUrl at properties file: " + baseUrl);

        return baseUrl;
    }
}