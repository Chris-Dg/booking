package learn.spring.booking.account.service;

import learn.spring.booking.account.domain.Member;
import learn.spring.booking.account.domain.MemberRepository;
import learn.spring.booking.advanced.trace.logtrace.LogTrace;
import learn.spring.booking.advanced.trace.strategy.context.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    private final Template template;

    public LoginService(MemberRepository memberRepository, LogTrace trace) {
        this.memberRepository = memberRepository;
        this.template = new Template(trace);
    }

    /**
     * @return null 로그인 실패
     */
    public Member login(String loginId, String password) {
        return template.execute("LoginService.login()", () -> {
            return memberRepository.findByLoginId(loginId)
                    .filter(m -> m.getPassword().equals(password))
                    .orElse(null);
        });
    }

}
