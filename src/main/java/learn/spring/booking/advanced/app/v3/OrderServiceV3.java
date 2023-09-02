package learn.spring.booking.advanced.app.v3;

import learn.spring.booking.advanced.trace.TraceId;
import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.helloTrace.HelloTraceV2;
import learn.spring.booking.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        TraceStatus traceStatus = null;

        try {
            traceStatus = trace.begin("OrderService.orderItem");
            orderRepositoryV3.save(itemId);
            trace.end(traceStatus);

        } catch (Exception e) {
            trace.exception(traceStatus, e);
            throw e;
        }

    }

}
