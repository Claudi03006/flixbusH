package com.savarino;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class FlixBusApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(FlixBusApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FlixBusApplication.class, args);
        logger.error("*** Flix Bus Start ERROR***");
        logger.warn("*** Flix Bus Start WARN***");
        logger.info("*** Flix Bus Start INFO***");
        logger.debug("*** Flix Bus Start DEBUG***");
        logger.trace("*** Flix Bus Start TRACE***");
    }

}
