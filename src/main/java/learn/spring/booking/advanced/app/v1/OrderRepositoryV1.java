package learn.spring.booking.advanced.app.v1;

import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.helloTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 helloTraceV1;

    public void save(String itemId) {

        TraceStatus traceStatus = null;

        try {
            traceStatus = helloTraceV1.begin("OrderRepository.save()");

            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }

            sleep(1000);

            helloTraceV1.end(traceStatus);

        } catch (Exception e) {
            helloTraceV1.exception(traceStatus, e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
