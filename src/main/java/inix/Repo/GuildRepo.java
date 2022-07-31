package inix.Repo;

import inix.model.Guild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuildRepo extends JpaRepository<Guild, Long> {
    Optional<Guild> findByName(String guildName);
}
