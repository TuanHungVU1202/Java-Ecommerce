package com.hv.ecommerce.configurations;

import com.hv.ecommerce.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Bean(name = "restClient")
    public RestTemplate getRestClient() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory
                = new SimpleClientHttpRequestFactory();
        //Connect timeout
        clientHttpRequestFactory.setConnectTimeout(Constant.CONNECTION_TIMEOUT);

        //Read timeout
        clientHttpRequestFactory.setReadTimeout(Constant.READ_TIMEOUT);
        return clientHttpRequestFactory;
    }
}
