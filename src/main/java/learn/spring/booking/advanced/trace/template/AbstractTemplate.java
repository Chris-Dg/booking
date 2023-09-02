package learn.spring.booking.advanced.trace.template;

import learn.spring.booking.advanced.trace.TraceStatus;
import learn.spring.booking.advanced.trace.logtrace.LogTrace;

/***
 *  템플릿 메서드 디자인 패턴의 목적은 다음과 같습니다.
 * "작업에서 알고리즘의 골격을 정의하고 일부 단계를 하위 클래스로 연기합니다. 템플릿 메서드를 사용하면
 * 하위 클래스가 알고리즘의 구조를 변경하지 않고도 알고리즘의 특정 단계를 재정의할 수 있습니다." [GOF]
 * @param <T>
 */
public abstract class AbstractTemplate<T> {

    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message); //로직 호출
            T result = call();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();

}
