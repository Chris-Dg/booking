package learn.spring.booking.reservation.domain;

import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 예약 기능 JDBC 기준으로 작성
 */
@Slf4j
@Repository
public class JdbcTemplateReservationRepository implements ReservationRepository {

    private final JdbcTemplate template;

    public JdbcTemplateReservationRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return null;
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Reservation> findAll(String guestId) {
        return null;
    }
}
