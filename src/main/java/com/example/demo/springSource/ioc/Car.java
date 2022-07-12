package com.example.demo.springSource.ioc;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author Jay
 * @description
 * @date Created in 2022/7/6 10:36 下午
 */
@Component
@Data
public class Car  implements FactoryBean {

    String name = "11";


    @Override
    public Object getObject() throws Exception {
        return new Tank();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
