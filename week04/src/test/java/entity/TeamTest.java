package entity;

import com.xjy.week04.entity.Team;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yjx
 * @date 2026/3/26
 * @description
 */

@SpringBootTest
@Slf4j
class TeamTest {
    @Resource
    private Team team;

    @Test
    void testTeam() {
        log.info("team: {}", team);
        assertTrue(team.getLeader().length() >= 2 && team.getLeader().length() <= 10);
        assertTrue(team.getAge() >= 20 && team.getAge() <= 60);
        assertTrue(team.getEmail().matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"));
        assertTrue(team.getPhone().matches("^[0-9]{11}$"));
        assertTrue(team.getCreateTime().isBefore(LocalDate.now()));
    }
}