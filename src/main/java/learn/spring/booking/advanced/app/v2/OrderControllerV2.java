package learn.spring.booking.advanced.app.v2;

import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;

    private final HelloTraceV2 helloTraceV2;

    @GetMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try {
            status = helloTraceV2.begin("OrderController.request()");
            orderServiceV2.orderItem(status.getTraceId(), itemId);
            helloTraceV2.end(status);
            return "ok";
        } catch (Exception e) {
            helloTraceV2.exception(status, e);
            throw e;
        }

    }

}
