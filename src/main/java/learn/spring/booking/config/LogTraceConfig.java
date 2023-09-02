package learn.spring.booking.config;

import learn.spring.booking.advanced.trace.logtrace.FieldLogTrace;
import learn.spring.booking.advanced.trace.logtrace.LogTrace;
import learn.spring.booking.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
