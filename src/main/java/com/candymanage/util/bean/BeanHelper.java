package com.candymanage.util.bean;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @packageName: candy
 * @author: hyb
 * @date: 2020-09-14 下午 4:08
 * @description: spring 的bean 操作辅助类
 */
public class BeanHelper {
    //得到bean
    public static <T> T getBean(String beanName, Class<T> clazz) {
        T typeObj = null;
        if (StringUtils.isNotBlank(beanName)) {
            WebApplicationContext ac = ContextLoader.getCurrentWebApplicationContext();
            Object object = ac.getBean(beanName);
            if (object != null) {
                typeObj = (T) object;
            }
        }
        return typeObj;
    }

}
