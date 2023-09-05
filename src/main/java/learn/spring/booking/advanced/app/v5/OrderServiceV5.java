package learn.spring.booking.advanced.app.v5;

import learn.spring.booking.advanced.trace.logtrace.LogTrace;
import learn.spring.booking.advanced.trace.strategy.context.Template;
import learn.spring.booking.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final Template template;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace trace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.template = new Template(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()",() -> {
            orderRepositoryV5.save(itemId);
            return null;
        });

    }

}
