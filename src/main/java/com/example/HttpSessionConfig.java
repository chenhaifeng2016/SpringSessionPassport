package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Created by chenh on 2017/4/15.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 180, redisNamespace = "passport")
public class HttpSessionConfig {
    /*
    HttpSessionStrategy token = new HeaderHttpSessionStrategy();

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return token;
    }
*/
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        System.out.println("-----------------------cookieHttpSessionStrategy----------------");

        CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
        strategy.setCookieSerializer(new CustomerCookieSerializer());
        return strategy;
    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }
}
