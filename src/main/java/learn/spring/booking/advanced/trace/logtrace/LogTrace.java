package learn.spring.booking.advanced.trace.logtrace;

import learn.spring.booking.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);

}
