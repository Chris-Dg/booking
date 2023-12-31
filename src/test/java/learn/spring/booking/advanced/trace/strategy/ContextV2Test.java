package learn.spring.booking.advanced.trace.strategy;

import learn.spring.booking.advanced.trace.strategy.code.strategy.ContextV2;
import learn.spring.booking.advanced.trace.strategy.code.strategy.StrategyTest;
import learn.spring.booking.advanced.trace.strategy.code.strategy.StrategyTestLogic1;
import learn.spring.booking.advanced.trace.strategy.code.strategy.StrategyTestLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyTestLogic1());
        context.execute(new StrategyTestLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyTest() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context.execute(new StrategyTest() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스2, 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}
