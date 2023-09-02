package learn.spring.booking.advanced.app.v2;

import learn.spring.booking.advanced.trace.TraceId;
import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 helloTraceV2;

    public void save(TraceId traceId, String itemId) {

        TraceStatus traceStatus = null;

        try {
            traceStatus = helloTraceV2.beginSync(traceId, "OrderRepository.save()");

            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }

            sleep(1000);

            helloTraceV2.end(traceStatus);

        } catch (Exception e) {
            helloTraceV2.exception(traceStatus, e);
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
