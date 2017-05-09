package com.ziyan.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by 子炎 on 2017/5/9.
 */
@Configuration
public class KapychaConfig {
    /*
    <!-- Kaptcha验证码生成器 -->
	<bean name="producer" class="com.google.code.kaptcha.impl.DefaultKaptcha" scope="singleton">
	    <property name="config">
	        <bean class="com.google.code.kaptcha.util.Config">
	            <constructor-arg>
	                <props>
	                    <prop key="kaptcha.border">no</prop>
	                    <prop key="kaptcha.textproducer.font.color">black</prop>
	                    <prop key="kaptcha.textproducer.char.space">5</prop>
	                </props>
	            </constructor-arg>
	        </bean>
	    </property>
	</bean>
    */

    @Bean
    public DefaultKaptcha producer() {
        DefaultKaptcha producer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.textproducer.char.space", "5");
        Config config = new Config(properties);
        producer.setConfig(config);
        return producer;
    }
}
