package learn.spring.booking.space.domain;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpaceMapper {

    void save(Space space);
    void update(@Param("id") Long id, @Param("updateParam") SpaceParam updateParam);
    Optional<Space> findById(Long id);
    List<Space> findAll(String hostId);

}
