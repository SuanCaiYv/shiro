package com.learn.shiro.util;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * @author SuanCaiYv
 * @time 2020/6/14 下午3:47
 */
public class PropertiesUtil {

    private static final String PROPERTIES_FILE_PATH = "properties.yml";

    private static Properties PROPERTIES = null;

    static {

        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource(PROPERTIES_FILE_PATH));
        PROPERTIES = yamlPropertiesFactoryBean.getObject();
    }

    public static String getProperties(String propertyName) {

        return PROPERTIES.getProperty(propertyName);
    }
}
