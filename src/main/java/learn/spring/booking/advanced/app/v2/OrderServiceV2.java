package learn.spring.booking.advanced.app.v2;

import learn.spring.booking.advanced.trace.TraceId;
import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 helloTraceV2;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus traceStatus = null;

        try {
            traceStatus = helloTraceV2.beginSync(traceId, "OrderService.orderItem");
            orderRepositoryV2.save(traceStatus.getTraceId(), itemId);
            helloTraceV2.end(traceStatus);

        } catch (Exception e) {
            helloTraceV2.exception(traceStatus, e);
            throw e;
        }

    }

}
