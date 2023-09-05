package learn.spring.booking.advanced.trace.strategy.context;

import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.logtrace.LogTrace;
import learn.spring.booking.advanced.trace.strategy.Callback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Template {

    private final LogTrace trace;

    public Template(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, Callback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message); //로직 호출
            T result = callback.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
