package com.exercise.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

@Configuration
public class FeignConfig {

        @Bean
        public feign.Retryer retryer() {
                return feign.Retryer.NEVER_RETRY; // desactiva los reintentos
        }
       @Bean
        public Request.Options feignRequestOptions() {
                return new Request.Options(
                        5000, // connect timeout en ms
                        5000  // read timeout en ms
                );
        }
}

