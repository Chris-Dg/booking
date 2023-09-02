package learn.spring.booking.advanced.app.v1;

import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.helloTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final HelloTraceV1 helloTraceV1;

    public void orderItem(String itemId) {

        TraceStatus traceStatus = null;

        try {
            traceStatus = helloTraceV1.begin("OrderService.orderItem");
            orderRepositoryV1.save(itemId);
            helloTraceV1.end(traceStatus);

        } catch (Exception e) {
            helloTraceV1.exception(traceStatus, e);
            throw e;
        }

    }

}
